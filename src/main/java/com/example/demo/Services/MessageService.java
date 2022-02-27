package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/* stereotype is generalizing.
* Spring says:
* i dont care what object is doing, i just care that its doing something
* Service is obj that has some logic that it can re-use
* Controller, Component, etc = stereotypes = beans
* MessageService is now bean b/c annotated as Service
 */
@Service
public class MessageService {
////for first and second way of doing dep. injection
//    //Bean is called messageService
//    //if want to rename bean, @Service("MyMessageServkce)
//
////constructor
//    public MessageService() {
//        System.out.println ("Spring is creating an instance of MessageService ");
//    }
//
//    private String message = "Hello World";
//
//    public String getMessage() {
//        return message;
//    }
//}
// ---------------------------------------------------------------

// 3rd way of doing, with yaml file

    @Value("${services.message-service.message}")
    private  String message;

    public MessageService(){
    System.out.println("Spring is creating an instance of MessageService ");
    }

    public String getMessage() {
        return message;
    }
}