package com.example.demo.Services;

import com.example.demo.Model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class EmailService {

    private JavaMailSender emailSender;

    @Autowired
    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }
    public void sendEmail(Mail mail) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setSubject(mail.getEmailSubject());
            mimeMessageHelper.setFrom(new InternetAddress(mail.getEmailFrom(), "gmail.com"));
            mimeMessageHelper.setTo(mail.getEmailTo());
            mimeMessageHelper.setText(mail.getEmailContent());

            emailSender.send(mimeMessageHelper.getMimeMessage());

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
