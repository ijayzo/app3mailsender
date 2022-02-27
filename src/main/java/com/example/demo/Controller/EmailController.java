package com.example.demo.Controller;

import com.example.demo.Model.Mail;
import com.example.demo.Services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmailController {

    private EmailService emailService;

    @Autowired
    EmailController(EmailService sendEmail) {
        this.emailService = sendEmail;
    }


    @PostMapping
    public ResponseEntity<?> sendEmails(@RequestBody List<String> list){
        emailService.sendEmail(new Mail("isaias.jasso@gmail.com", list.get(0), "", "", "Employee Reimbursement Request", "Your Reimbursement Request for the amount $" +
                list.get(1) + " has been " + list.get(2) + ".", ""));

        return ResponseEntity.accepted().build();
    }
}
