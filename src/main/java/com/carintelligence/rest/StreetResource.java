package com.carintelligence.rest;

import com.carintelligence.model.Street;
import com.carintelligence.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author leonardo
 * @project carintelligence
 * @date 20/3/17
 */
@Component
@Path("/streets")
public class StreetResource {
    @Autowired
    private StreetService streetService;

    private final String resourceURI = "/streets";

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Street> list(@DefaultValue("0") @QueryParam("offset") int offset, @DefaultValue("20") @QueryParam("limit") int limit)
    {
        // Handles GET on /streets. Lists all the streets we have in our system.
        return streetService.paginate(offset, limit);
    }


    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("/{streetId}")
    public Street get(@PathParam("streetId") String streetId)
    {
        // Handles GET on /streets/{streetId}. Returns a single street for the given streetId.
        System.out.println("\n\n\nThis is the Id I recieved: " + streetId);
        Long streetIdl = 0L;
        return streetService.find(streetIdl);
    }


    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response create(Street street, @Context final HttpServletResponse response) throws URISyntaxException
    {
        // Handles POST on /streets. Creates a new street and adds it into an repository.
        streetService.save(street);
        response.setStatus(Response.Status.CREATED.getStatusCode());
        return Response.created(new URI(resourceURI + street.getStreetId())).build();
    }


    @PUT
    @Path("/{streetId}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Street update(Street street, @PathParam("streetId") Long streetId)
    {
        // Handles PUT on /streets/streetId. Updates the existing street with the new values.
        return streetService.update(street, streetId);
    }


    @DELETE
    @Path("/{streetId}")
    public Street delete(@PathParam("streetId") Long streetId)
    {
        // Handles DELETE on /streets/streetId. Deletes the existing street and returns the same.
        return streetService.delete(streetId);
    }
}
