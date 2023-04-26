package org.hadif.controller;

import org.hadif.service.MediaCollectionService;
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


import java.util.List;
import java.util.Map;;
import javax.inject.Inject;
import org.hadif.model.MediaCollection;
import org.hadif.model.MediaCollectionItem;



@Path("/collection")
@Consumes("application/json")
@Produces("application/json")
public class MediaCollectionController {
    @Inject
    MediaCollectionService service;

    private final String DEFAULT_PAGE_SIZE = "10";

    @GET
    public Map<String,Object> list( @QueryParam("page") @DefaultValue("1") Integer page, 
                                    @QueryParam("size") @DefaultValue(DEFAULT_PAGE_SIZE) Integer size) {
        return service.listAll(page,size);
    }

    @POST
    public MediaCollection create(MediaCollection mediaCollection) {
        return service.createMediaCollection(mediaCollection);
    }

    @PUT
    @Path("/{id}")
    public MediaCollection update(@PathParam("id") Integer id, MediaCollection mediaCollection) {
        return service.updateMediaCollection(id,mediaCollection);
    }

    @DELETE
    @Path("/{id}")
    public MediaCollection delete(@PathParam("id") Integer id) {
        return service.deleteMediaCollection(id);
    }

    @GET
    @Path("/{id}")
    public MediaCollection findById(@PathParam("id") Integer id) {
        return service.findById(id);
    }
    
    @GET
    @Path("/m")
    public MediaCollectionItem[] m() {
        return service.getAllItems();
    }
}
