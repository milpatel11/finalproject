//   Assignment 2
//        * Assignment: 2
//        * Author(s):
//        * Student Number:
//        * Date: November 8, 2020
//        * Description: This file sends the captcha
package com.example.demo;

import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.repos.RoleRepository;
import com.example.demo.repos.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoSeeder {
    private RoleRepository roleRepository;
    private ClientRepository clientRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public DemoSeeder(RoleRepository roleRepository, ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void seedDatabase() {
        Role roleUser = new Role("USER");
        Role roleAdmin = new Role("ADMIN");

            User admin = new User("admin", "admin" , "1st street", passwordEncoder.encode("P@ssword!"), "admin@isp.net");
        User user1 = new User("user", "one", "2nd street",passwordEncoder.encode("password"), "one@mail.com");
        User user2 = new User("user", "two", "2nd street",passwordEncoder.encode("password"), "two@mail.com");

        admin.getRoleList().add(roleAdmin);
        admin.getRoleList().add(roleUser);
        user1.getRoleList().add(roleUser);
        user2.getRoleList().add(roleUser);

        roleRepository.save(roleUser);
        roleRepository.save(roleAdmin);

        clientRepository.save(admin);
        clientRepository.save(user1);
        clientRepository.save(user2);
    }

    public void displayDatabaseToConsole() {
        //users
        List<User> users = clientRepository.findAll();
        System.out.println("====================== USER ===================");
        for (User user : users) {
            System.out.println(user);
        }

        //roles
        System.out.println("====================== ROLES ===================");
        List<Role> roles = roleRepository.findAll();
        for (Role role : roles) {
            System.out.println(role);
        }
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runTest() {
        seedDatabase();
        displayDatabaseToConsole();
    }
}
