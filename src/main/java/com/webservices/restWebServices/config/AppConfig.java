package com.webservices.restWebServices.config;

import com.webservices.restWebServices.resources.BookResourceImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/bookstore")
public class AppConfig extends ResourceConfig {

    @PostConstruct
    private void init() {
        registerClasses(BookResourceImpl.class);
    }
}
