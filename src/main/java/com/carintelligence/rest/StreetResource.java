package com.carintelligence.rest;

import com.carintelligence.model.ApiResponse;
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

    ApiResponse response = new ApiResponse();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@DefaultValue("0") @QueryParam("offset") int offset, @DefaultValue("20") @QueryParam("limit") int limit)
    {
        // Handles GET on /streets. Lists all the streets we have in our system.
        response = new ApiResponse(Response.Status.OK.getStatusCode(), "Street");
        try {
            //Generate response generic
            response = new ApiResponse(Response.Status.OK.getStatusCode(),Response.Status.OK.getReasonPhrase());
            //Load object at list
            List<Street> entitiesList = streetService.paginate(offset, limit);
            response.getEntities().addAll(entitiesList);
        } catch (Exception e){
            response = new ApiResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
            //return error message
            return Response.status(Response.Status.OK.getStatusCode()).entity(response).build();
        }
        //return response
        return Response.status(Response.Status.OK.getStatusCode()).entity(response.toJSON()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{streetId}")
    public Response get(@PathParam("streetId") Long streetId)
    {
        // Handles GET on /streets/{streetId}. Returns a single street for the given streetId.
        response = new ApiResponse(Response.Status.OK.getStatusCode(), "Street");
        try {
            //Generate response generic
            response = new ApiResponse(Response.Status.OK.getStatusCode(),Response.Status.OK.getReasonPhrase());
            //Load object at list
            response.getEntities().add(streetService.find(streetId));
        } catch (Exception e){
            response = new ApiResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
            //return error message
            return Response.status(Response.Status.OK.getStatusCode()).entity(response).build();
        }
        //return response
        return Response.status(Response.Status.OK.getStatusCode()).entity(response.toJSON()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(String json) throws URISyntaxException
    {
        // Handles POST on /streets. Creates a new street and adds it into an repository.
        response = new ApiResponse(Response.Status.CREATED.getStatusCode(), "Street");
        Street street = new Street();
        try {
            if (json!=null) {
                response = new ApiResponse(Response.Status.CREATED.getStatusCode(), Response.Status.CREATED.getReasonPhrase());
                street = streetService.save(street.EntityfromJson(json));
                response.getEntities().add(street);
            }else{
                response = new ApiResponse(Response.Status.BAD_REQUEST.getStatusCode(), Response.Status.BAD_REQUEST.getReasonPhrase());
            }
        } catch (Exception e) {
            response = new ApiResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }

        return Response.status(Response.Status.OK.getStatusCode()).entity(response.toJSON()).build();
    }

    @PUT
    @Path("/{streetId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
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
