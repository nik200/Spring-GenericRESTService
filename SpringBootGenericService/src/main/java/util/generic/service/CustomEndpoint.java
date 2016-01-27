package util.generic.service;

import generic.spring.implementations.GenericSpringService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class CustomEndpoint implements Endpoint<Object> {
     
	@Autowired
	private Environment env;

	
	
    public String getId() {
        return env.getProperty("management.custom.endpoint");
    }
 
    public boolean isEnabled() {
        return true;
    }
 
    public boolean isSensitive() {
        return true;
    }
 
    public Object invoke() {
        return GenericSpringService.getMonitorObject();
    }
}