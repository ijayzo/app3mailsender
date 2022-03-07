package com.example.demo.Controller;

import com.example.demo.Model.CancelMailTemplate;
import com.example.demo.Model.Mail;
import com.example.demo.Model.MailSenderCreatePackage;
import com.example.demo.Services.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/** This restcontroller exposes the API for email sending
 *
 */
@RestController
@RequestMapping("mailapi")
public class EmailController {

    private final Logger logger =
            LoggerFactory.getLogger(EmailController.class);
    private EmailService emailService;

    @Autowired
    EmailController(EmailService sendEmail) {
        this.emailService = sendEmail;
    }



    /**
     * API to send the cancellation email using the Template passed as parameter
     * @param theTemplate - template containing the cancellation details so that the email is personalized
     * @return success message
     * @throws AddressException
     * @throws MessagingException
     * @throws IOException
     */
    @PostMapping("/sendCancelEmail")
    public ResponseEntity getFromAPI(@RequestBody CancelMailTemplate theTemplate) throws AddressException, MessagingException, IOException{

        Mail mail = new Mail();
        mail.setEmailFrom("pogidevs@gmail.com");
        mail.setEmailTo(theTemplate.getEmailTo());
        mail.setEmailSubject("You Package booking has been cancelled");
        mail.setEmailContent("Dear Employee,\n\nWe are sorry to inform you that below package has been cancelled due to " + theTemplate.getCancelReason() + ".\n\nPackage Description:\n\n" + theTemplate.getPackageDesc()  + "\n\nYou may select other available packages for you next holiday.\n\nThanks\nDevOps SRE Team4");

        emailService.sendEmail(mail);
        logger.info("Package Cancellation Email Sent to: " + theTemplate.getEmailTo());

        return ResponseEntity.status(HttpStatus.OK)
                .body("Email sent successfully to " + theTemplate.getEmailTo());
    }

    /**
     * API to send a test email to a predefined address and using a sepcified format.  mostly to be used in checking if email services are up
     * @return success message
     * @throws AddressException
     * @throws MessagingException
     * @throws IOException
     */
    @PostMapping(value = "/sendTestEmail")
    public ResponseEntity sendTestEmail() throws AddressException, MessagingException, IOException {
        sendtestmail();
        logger.info("Test Email Sent to noel.gopez@revature.net");
        return ResponseEntity.status(HttpStatus.OK)
                .body("Test Email sent successfully");
    }

    /** send a test email on a predefined address with predefined content.
     *
     * @throws AddressException
     * @throws MessagingException
     * @throws IOException
     */
    private void sendtestmail() throws AddressException, MessagingException, IOException {
        Mail mail = new Mail();
        mail.setEmailFrom("pogidevs@gmail.com");
        mail.setEmailTo("noel.gopez@revature.net");
        mail.setEmailSubject("Test Email Project 2 Team  4");
        mail.setEmailContent("Dear Employee,\n\nYou have Triggered Auto email sending from Project 2\n\nThanks\nDevOps SRE Team4");

        emailService.sendEmail(mail);

    }

    /**
     * API to send the cancellation email using the Template passed as parameter
     * @param mailSenderCreatePackage - template containing the cancellation details so that the email is personalized
     * @return success message
     * @throws AddressException
     * @throws MessagingException
     * @throws IOException
     */
    @PostMapping("/createdPackage")
    public ResponseEntity getFromCreatingPackage(@RequestBody MailSenderCreatePackage mailSenderCreatePackage) throws AddressException, MessagingException, IOException{

        Mail mail = new Mail();
        mail.setEmailFrom("pogidevs@gmail.com");
        mail.setEmailTo(mailSenderCreatePackage.getEmail());
        mail.setEmailSubject("Your Package has been Booked ");
        mail.setEmailContent("Dear Employee,\n\nYour  package has been successfully created. Please Check the Website Portal for more information\n\nThanks\nDevOps SRE Team4");

        emailService.sendEmail(mail);
        logger.info("Package Cancellation Email Sent to: " + mailSenderCreatePackage.getEmail());

        return ResponseEntity.status(HttpStatus.OK)
                .body("Email sent successfully to " + mailSenderCreatePackage.getEmail());
    }


    @PostMapping("/createdEmployee")
    public ResponseEntity getFromCreatingEmployee(@RequestBody MailSenderCreatePackage mailSenderCreatePackage) throws AddressException, MessagingException, IOException{

        Mail mail = new Mail();
        mail.setEmailFrom("pogidevs@gmail.com");
        mail.setEmailTo(mailSenderCreatePackage.getEmail());
        mail.setEmailSubject("Welcome To Vacation Portal ");
        mail.setEmailContent("Dear " + mailSenderCreatePackage.getEmail() +      " ,\n\nYour  account has been successfully created. Please Check the Website Portal for more information\n\nThanks\nDevOps SRE Team4");

        emailService.sendEmail(mail);
        logger.info("Package Cancellation Email Sent to: " + mailSenderCreatePackage.getEmail());

        return ResponseEntity.status(HttpStatus.OK)
                .body("Email sent successfully to " + mailSenderCreatePackage.getEmail());
    }

}
