//   Assignment 2
//        * Assignment: 2
//        * Author(s):
//        * Student Number:
//        * Date: November 8, 2020
//        * Description: This file sends the captcha
package com.example.demo.controllers;

import com.example.demo.RepositoryImplementation;
import com.example.demo.models.Credit;
import com.example.demo.models.Inbox;
import com.example.demo.models.User;
import com.example.demo.repos.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
public class TabController {
    private final RepositoryImplementation repositoryImplementation;

    @Autowired
    public TabController(RepositoryImplementation repositoryImplementation) {
        this.repositoryImplementation = repositoryImplementation;
    }

    @PostMapping("/profile")
    public String displayProfile(Model model){
        UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "profile";
    }
    @PostMapping("/addUser")
    public static String addUser(@Valid User user, BindingResult Result,Model models){
        ClientRepository.save(user);
        return "redirect:dashboard";
    }
    @GetMapping("/credit")
    public String displayCredit(Model model){
        UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        User activeUser = (User) user;
        Optional<Credit> inboxes = repositoryImplementation.findCreditByUser(activeUser.getEmail());
        model.addAttribute("inboxes", inboxes);
        return "tab";
    }
    @GetMapping("/inbox")
    public String displayInbox(Model model){
        UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        User activeUser = (User) user;
        Optional<Inbox> inboxes = repositoryImplementation.findAllByUserInbox(activeUser.getId());
        model.addAttribute("inboxes", inboxes);
        return "inbox";
    }
    @GetMapping("/support")
    public String displaySupport(Model model){
        UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        User activeUser = (User) user;
        Optional<Inbox> inboxes = repositoryImplementation.findAllByUserInbox(activeUser.getId());
        model.addAttribute("inboxes", inboxes);
        return "support";
    }

//    @GetMapping("/dashboard")
//    public String displayDashboard(Model model){
//        UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        model.addAttribute("user", user);
//        return "dashboard";
//    }
}
