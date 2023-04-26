package org.hadif.resource;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.rest.client.inject.RestClient;
//import io.quarkus.infinispan.client.Remote;
//import org.infinispan.client.hotrod.RemoteCache;
import org.hadif.service.MediaProxyService;


@Path("/ott")
@Consumes("application/json")
@Produces("application/json")
public class GatewayResource {
    @Inject
    @RestClient
    MediaProxyService mediaService;

    @Inject
    @Remote("media")
    RemoteCache<Integer, List> cache;

    @GET
    @Path("/media")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String,Object> listAllMedia(@QueryParam("page")  Integer page, 
                             @QueryParam("size") Integer size) {
        //System.out.println(cache.get(1));
        //cache.put(1, list);                    
        return mediaService.listAllMedia(page,size); 
    }

    @POST
    @Path("/media")
    @Produces(MediaType.APPLICATION_JSON)
    public Object createMedia(Object media) {
        return mediaService.createMedia(media); 
    }


    @GET
    @Path("/media/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String,Object> search(  @QueryParam("name") String name, 
                                @QueryParam("value") String values,
                                @QueryParam("page") Integer page, 
                                @QueryParam("size") Integer size) {
        return mediaService.findByMetadata(name, values,page,size);
    }

    @POST
    @Path("/collection")
    @Produces(MediaType.APPLICATION_JSON)
    public Object createMediaCollection(Object mediaC) {
        return mediaService.createMediaCollection(mediaC); 
    }


    @GET
    @Path("/collection")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Object> listAllMediaCollection(@QueryParam("page")  Integer page, 
                             @QueryParam("size") Integer size) {
        return mediaService.listAllMediaCollection(page,size);
    }

   
}