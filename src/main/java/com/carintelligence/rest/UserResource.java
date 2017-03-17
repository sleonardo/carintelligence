package com.carintelligence.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
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
import javax.ws.rs.core.Context;
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
            List<User> entitiesList = userService.paginate(offset, limit);
            response.getEntities().addAll(entitiesList);
            //retornamos la respuesta
        } catch (Exception e){
            response = new ApiResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
            return Response.status(Response.Status.OK.getStatusCode()).entity(response).build();
        }

        return Response.status(Response.Status.OK.getStatusCode()).entity(response).build();
//        return userService.paginate(offset, limit);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public User get(@PathParam("userId") Long userId)
    {
        // Handles GET on /users/{userId}. Returns a single user for the given userId.
        return userService.find(userId);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes( MediaType.APPLICATION_JSON)
    public Response create(User user, @Context final HttpServletResponse response) throws URISyntaxException
    {
        // Handles POST on /users. Creates a new user and adds it into an repository.
        userService.save(user);
        response.setStatus(Response.Status.CREATED.getStatusCode());
        return Response.created(new URI(resourceURI + user.getId())).build();
    }


    @PUT
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User update(User user, @PathParam("userId") Long userId)
    {
        // Handles PUT on /users/userId. Updates the existing user with the new values.
        return userService.update(user, userId);
    }


    @DELETE
    @Path("/{userId}")
    public User delete(@PathParam("userId") Long userId)
    {
        // Handles DELETE on /users/userId. Deletes the existing user and returns the same.
        return userService.delete(userId);
    }
}
