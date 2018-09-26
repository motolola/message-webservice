package com.tantalumcorporation.microservice.microone;


import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/king")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        //packages("com.tantalumcorporation.jerseyresource");
    }

}
