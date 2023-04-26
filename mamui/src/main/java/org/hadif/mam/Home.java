package org.hadif.mam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import javax.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import javax.ws.rs.Path;

@Path("/")
public class Home {
    @Inject
    Template home; 

    @Inject
    Template media; 

    @Inject
    Template mediaEdit; 

    @ConfigProperty(name = "gateway.url")
    String gatewayURL;

    String message = "Find ";

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance home() {
        return  home.data("gatewayURL",gatewayURL)
                    .data("message",message);
    }

    @GET
    @Path("/media")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance media() {
        return  media.data("gatewayURL",gatewayURL);
    }

    @GET
    @Path("/media-edit")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance mediaEdit() {
        return  mediaEdit.data("gatewayURL",gatewayURL);
    }
}