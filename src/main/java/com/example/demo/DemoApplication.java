package com.example.demo;

import com.example.demo.Services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/*
*.class is using the main class as a root class... this is apllication context
*passing in basic class that is going to startup the application context
*application context = eagerly instantiates beans... makes beans ... opens up new ability to support new modules for bean
*bean factory(?) = making beans
*spring bean = java class/object that is being managed by spring
*lazy initialization vs eager initialization.
*impacted at runtime. initializes on demand.
*IOC give control to other object
*spring boot gives control to app.context to create and inject beans where rerquesteded
*spring boot = injection container. creates application context. what does it want
*	is spring trying to inject and create for me
*
* Spring Bena Life Cycle : Constructor and Setter Methods
 */

@SpringBootApplication
public class DemoApplication {


	private MessageService service;
	@Autowired
	public void setService(MessageService service) {
		this.service = service;
	}

	public static void main(String[] args){
		SpringApplication.run(DemoApplication.class, args);
	}


}
