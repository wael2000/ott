package org.hadif.controller;

import org.hadif.service.MediaService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;

import java.util.Map;
import javax.inject.Inject;
import org.hadif.model.Media;


@Path("/media")
@Consumes("application/json")
@Produces("application/json")
public class MediaController {
    @Inject
    MediaService service;
    private final String DEFAULT_PAGE_SIZE = "10";

    @GET
    public Map<String,Object> list( @QueryParam("page") @DefaultValue("1") Integer page, 
                                    @QueryParam("size") @DefaultValue(DEFAULT_PAGE_SIZE) Integer size) {
        return service.listAll(page,size);
    }

    @POST
    public Media create(Media media) {
        return service.createMedia(media);
    }

    @PUT
    @Path("/{id}")
    public Media update(@PathParam("id") Integer id, Media media) {
        return service.updateMedia(id,media);
    }

    @DELETE
    @Path("/{id}")
    public Media delete(@PathParam("id") Integer id) {
        return service.deleteMedia(id);
    }

    @GET
    @Path("/{id}")
    public Media findById(@PathParam("id") Integer id) {
        return service.findById(id);
    }

    @GET
    @Path("/search")
    public Map<String,Object> search(  @QueryParam("name") String name, 
                                @QueryParam("value") String values,
                                @QueryParam("page") @DefaultValue("1") Integer page, 
                                @QueryParam("size") @DefaultValue(DEFAULT_PAGE_SIZE) Integer size) {
        return service.findByMetadata(name, values,page,size);
    }
    
}
