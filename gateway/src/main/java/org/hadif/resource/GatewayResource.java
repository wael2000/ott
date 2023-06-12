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
import javax.ws.rs.PathParam;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.hadif.service.MediaProxyService;


@Path("/ott")
@Consumes("application/json")
@Produces("application/json")
public class GatewayResource {
    @Inject
    @RestClient
    MediaProxyService mediaService;

    @GET
    @Path("/media")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String,Object> listAllMedia(@QueryParam("page")  Integer page, 
                             @QueryParam("size") Integer size) {
        return mediaService.listAllMedia(page,size); 
    }

    @GET
    @Path("/media/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public  Object findMediaById(@PathParam("id") Integer id) {
        return mediaService.findMediaById(id); 
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

    @GET
    @Path("/media/user")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String,Object> findByUser(  @QueryParam("user") String user, 
                                @QueryParam("page") Integer page, 
                                @QueryParam("size") Integer size) {
        return mediaService.findByUser(user,page,size);
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