//   Assignment 2
//        * Assignment: 2
//        * Author(s):
//        * Student Number:
//        * Date: November 8, 2020
//        * Description: This file sends the captcha
package com.example.demo.controllers;

import com.example.demo.RepositoryImplementation;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
public class ClientsController {
    private RepositoryImplementation repositoryImplementation;

    @Autowired
    public ClientsController(RepositoryImplementation repositoryImplementation) {
        this.repositoryImplementation = repositoryImplementation;
    }

    @GetMapping("user")
    public String loadUsrPanel(Model model) throws NotFoundException {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        if(user.isEmpty()){
            return "login";
        }
        model.addAttribute("user", user);
        return "user";
    }
}
