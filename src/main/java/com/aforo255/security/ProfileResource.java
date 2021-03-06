package com.aforo255.security;

import java.util.HashMap;

import javax.annotation.security.PermitAll;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.aforo255.security.service.TokenService;



@Path("/profile")
@RequestScoped
public class ProfileResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Mi nombre es Stywar!!!1...44444...5555";
    }
    
    @Inject
    TokenService service;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public HashMap<String, String> register(@QueryParam("username") String username,
                           @QueryParam("password") String password
                           ) {
    	
    	String email = "ObtenerBD";
    	// Tarea para los alumnos ,obtener el email de BD . 

        final String token = service.generateToken(username,email);
        return new HashMap<String, String>() {{
            put("token", token);
        }};
    }
}