package org.hadif.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/")
@RegisterRestClient
public interface MediaProxyService {

    /**
     * list media items
     * @param page
     * @param size
     * @return
     */
    @GET
    @Path("/media")
    @Produces("application/json")
    Map<String,Object> listAllMedia(@QueryParam("page") Integer page,@QueryParam("size") Integer size);

    /**
     * 
     * @param media
     * @return
     */
    @POST
    @Path("/media")
    @Produces("application/json")
    Object createMedia(Object media);
    
    @GET
    @Path("/media/search")
    @Produces("application/json")
    Map<String,Object> findByMetadata(@QueryParam("name") String name, 
                                    @QueryParam("value") String values,
                                    @QueryParam("page") Integer page,
                                    @QueryParam("size") Integer size);

    /**
     * list media collections
     * @param page
     * @param size
     * @return
     */
    @GET
    @Path("/collection")
    @Produces("application/json")
    List<Object> listAllMediaCollection(@QueryParam("page") Integer page,@QueryParam("size") Integer size);
    
    /**
     * 
     * @param mediaCollection
     * @return
     */
    @POST
    @Path("/collection")
    @Produces("application/json")
    Object createMediaCollection(Object mediaCollection);
}