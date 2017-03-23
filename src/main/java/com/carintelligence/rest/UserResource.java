package com.carintelligence.rest;

import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.carintelligence.model.ApiResponse;
import com.carintelligence.model.User;
import com.carintelligence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Project: carintelligence
 * Created by Leonardo Simoza on 09/3/17.
 **/
@Component
@Path("/users")
public class UserResource
{

    @Autowired
    private UserService userService;

    private final String resourceURI = "/users";

    ApiResponse response = new ApiResponse();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@DefaultValue("0") @QueryParam("offset") int offset, @DefaultValue("20") @QueryParam("limit") int limit)
    {
        // Handles GET on /users. Lists all the users we have in our system.
        response = new ApiResponse(Response.Status.OK.getStatusCode(), "User");
        try {
            //Creamos la respuesta generica del API
            response = new ApiResponse(Response.Status.OK.getStatusCode(),Response.Status.OK.getReasonPhrase());
            //cargamos el objeto a leer desde el cliente
            response.getEntities().addAll(userService.paginate(offset, limit));
            //retornamos la respuesta
        } catch (Exception e){
            response = new ApiResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
            return Response.status(Response.Status.OK.getStatusCode()).entity(response).build();
        }

        return Response.status(Response.Status.OK.getStatusCode()).entity(response.toJSON()).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public Response get(@PathParam("userId") Long userId)
    {
        // Handles GET on /users/{userId}. Returns a single user for the given userId.
        response = new ApiResponse(Response.Status.OK.getStatusCode(), "Street");
        try {
            //Generate response generic
            response = new ApiResponse(Response.Status.OK.getStatusCode(),Response.Status.OK.getReasonPhrase());
            User user = userService.find(userId);
            //Load object at list
            if(user!=null)
                response.getEntities().add(user);
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
    @Consumes( MediaType.APPLICATION_JSON)
    public Response create(User user) throws URISyntaxException
    {
        // Handles POST on /users. Creates a new user and adds it into an repository.
        response = new ApiResponse(Response.Status.CREATED.getStatusCode(), "User");
        try {
            if (user!=null) {
                response = new ApiResponse(Response.Status.CREATED.getStatusCode(), Response.Status.CREATED.getReasonPhrase());
                user = userService.save(user);
                response.getEntities().add(user);
            }else{
                response = new ApiResponse(Response.Status.BAD_REQUEST.getStatusCode(), Response.Status.BAD_REQUEST.getReasonPhrase());
            }
        } catch (Exception e) {
            response = new ApiResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }

        return Response.status(Response.Status.OK.getStatusCode()).entity(response.toJSON()).build();
    }


    @PUT
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(User user, @PathParam("userId") Long userId)
    {
        // Handles PUT on /users/userId. Updates the existing user with the new values.
        response = new ApiResponse(Response.Status.CREATED.getStatusCode(), "User");
        try {
            if (user!=null && userId!=null) {
                response = new ApiResponse(Response.Status.OK.getStatusCode(), Response.Status.OK.getReasonPhrase());
                user = userService.update(user, userId);
                response.getEntities().add(user);
            }else{
                response = new ApiResponse(Response.Status.BAD_REQUEST.getStatusCode(), Response.Status.BAD_REQUEST.getReasonPhrase());
            }
        } catch (Exception e) {
            response = new ApiResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }

        return Response.status(Response.Status.OK.getStatusCode()).entity(response.toJSON()).build();
    }


    @DELETE
    @Path("/{userId}")
    public Response delete(@PathParam("userId") Long userId)
    {
        // Handles DELETE on /users/userId. Deletes the existing user and returns the same.
        response = new ApiResponse(Response.Status.OK.getStatusCode(), "User");
        try {
            //Generate response generic
            response = new ApiResponse(Response.Status.OK.getStatusCode(),"User removed");
            User user = userService.delete(userId);
            //Load object at list
            if(user!=null)
                response.getEntities().add(user);
            else
                response = new ApiResponse(Response.Status.NOT_FOUND.getStatusCode(),Response.Status.NOT_FOUND.getReasonPhrase());
        } catch (Exception e){
            response = new ApiResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
            //return error message
            return Response.status(Response.Status.OK.getStatusCode()).entity(response).build();
        }
        //return response
        return Response.status(Response.Status.OK.getStatusCode()).entity(response.toJSON()).build();

    }
}
