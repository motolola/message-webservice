package com.tantalumcorporation.jerseyresource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/animal")
public class Animal {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("show")
    public List<String> showAnimal()
    {
        List<String> user = new ArrayList<>();
        user.add("Jide");
        user.add("United Kingdom");
        user.add("Nigerian");

        return user;
    }
}
