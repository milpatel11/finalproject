//   Assignment 2
//        * Assignment: 2
//        * Author(s):
//        * Student Number:
//        * Date: November 8, 2020
//        * Description: Authentican Contoller
package com.example.demo.controllers;

import com.example.demo.CaptchaService;
import com.example.demo.RepositoryImplementation;
import com.example.demo.models.User;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.*;
import javax.mail.internet.*;
import javax.validation.Valid;
import java.util.Date;
import java.util.Properties;

//        * Assignment: 2
//        * Author(s):
//       <!--
//        1. UrvishKumar Patel
//        2. Milankumar Patel
//        3. Henok Mengesha
//        4. Matthew Mukherjee
//        5. Dhyankumar Patel
//        -->
//        * Student Number respectively:
//101212717
//101153456
//101158122
//101190394
//101179309

//        * Date: Dec 06, 2020


@Controller
public class AuthenticationController {

    private RepositoryImplementation repository;
    @Autowired
    CaptchaService captchaService;

    // Autoload the ClientRepository
    @Autowired
    public AuthenticationController(RepositoryImplementation repository) {
        this.repository = repository;
    }

    // Redirect user to login
    @GetMapping("/login")
    public String renderLogin() {
        return "login";
    }

    @GetMapping("/")
    public String getWelcome() throws NotFoundException {
        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "redirect:/dashboard";
        }
        return "redirect:/profile";
    }

    @GetMapping("/register")
    public String registerUSer(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user, Errors errors, Model model) throws MessagingException {
        if (repository.validateEmail(user.getEmail())) {
            model.addAttribute("present", true);
            return "register";
        }
        if (errors.hasErrors()) {
            model.addAttribute("error", errors.getAllErrors().get(0));
            return "register";
        } else {
            if (user.getPassword().length() < 12 && user.getPassword().length() > 6) {


                for (int i = 1; i <= user.getPassword().length(); i++) {
                    char current = user.getPassword().charAt(i-1);
                    if (Character.isUpperCase(current)) {
                        for (int j = 1; j <= user.getPassword().length(); j++) {
                            char currentSys = user.getPassword().charAt(j-1);
                            if (!Character.isAlphabetic(currentSys)) {
                                sendmail(user);
                                repository.saveUser(user);
                                model.addAttribute("complete", "Registration Complete");
                                return "login";
                            } else {
                                if (i == user.getPassword().length())
                                    model.addAttribute("error", "Password must contain symbol");
                            }

                        }

                    } else {
                        if (i == user.getPassword().length())
                            model.addAttribute("error", "Password must contain an uppercase letter");
                    }
                }
            } else {
                model.addAttribute("error", "Password must be 6-12 characters");
            }
        }

        return "register";
    }

    private void sendmail(User user) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.mailtrap.io");
        props.put("mail.smtp.port", "2525");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("e3efb2e70f6ba7", "53beeeb6e8652a");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("e3efb2e70f6ba7@example.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
        msg.setSubject("Account Verification");
        msg.setContent(user.getFirstName() + " " + user.getLastName() + ", " + user.getAddress() + " , Your account is created", "text/html");
        msg.setSentDate(new Date());
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Account Successfully created. <a href='http://localhost:8080/lohin'>Log into your account</a> <", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart attachPart = new MimeBodyPart();

        msg.setContent(multipart);
        Transport.send(msg);
    }

}
