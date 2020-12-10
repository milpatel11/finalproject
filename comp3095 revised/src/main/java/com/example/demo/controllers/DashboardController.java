//   Assignment 2
//        * Assignment: 2
//        * Author(s):
//        * Student Number:
//        * Date: November 8, 2020
//        * Description: This file sends the captcha
package com.example.demo.controllers;

import com.example.demo.RepositoryImplementation;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

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
public class DashboardController {
    private RepositoryImplementation repositoryImplementation;

    @Autowired
    public DashboardController(RepositoryImplementation repositoryImplementation) {
        this.repositoryImplementation = repositoryImplementation;
    }

    @GetMapping("/dashboard")
    public String display(Model model){
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("user", user);
        List<User> allUsers = repositoryImplementation.findAllUsers();
        model.addAttribute("users", allUsers);
        model.addAttribute("last_login", new Date().toString());
        model.addAttribute("last_update", new Date().toString());
        model.addAttribute("inbox", 0);
        model.addAttribute("unread", 0);
        return "dashboard";
    }
}
