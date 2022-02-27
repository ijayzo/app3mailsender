package com.example.demo.Model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Mail {

    private String emailFrom;
    private String emailTo;
    private String emailCc;
    private String emailBcc;
    private String emailSubject;
    private String emailContent;
    private String contentType;
}
