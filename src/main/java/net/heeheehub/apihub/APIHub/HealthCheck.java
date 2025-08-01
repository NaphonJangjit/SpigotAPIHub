package net.heeheehub.apihub.APIHub;

import net.heeheehub.apihub.APIHub.development.APIController;

public class HealthCheck {


    @APIController("health")
    public String hello(){
        return "I'm good bro";
    }
	
}
