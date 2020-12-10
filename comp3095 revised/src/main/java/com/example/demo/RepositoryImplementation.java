//   Assignment 2
//        * Assignment: 2
//        * Author(s):
//        * Student Number:
//        * Date: November 8, 2020
//        * Description: This file sends the captcha
package com.example.demo;

import com.example.demo.models.Credit;
import com.example.demo.models.Inbox;
import com.example.demo.models.User;
import com.example.demo.repos.CreditRepository;
import com.example.demo.repos.InboxRepository;
import com.example.demo.repos.RoleRepository;
import com.example.demo.repos.ClientRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepositoryImplementation {
    private ClientRepository clientRepository;
    private InboxRepository inboxRepository;
    private CreditRepository creditRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RepositoryImplementation(ClientRepository clientRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, InboxRepository inboxRepository, CreditRepository creditRepository) {
        this.clientRepository = clientRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.inboxRepository = inboxRepository;
        this.creditRepository = creditRepository;
    }

    public User saveUser(User user) {
        user.getRoleList().add(roleRepository.findByRolename("USER"));
        String passBCrypt = passwordEncoder.encode(user.getPassword());
        user.setPassword(passBCrypt);
        return clientRepository.save(user);
    }

    public void deleteUser(Long id) throws NotFoundException {
        clientRepository.deleteById(id);
    }

    public List<User> findAllUsers() {
        return clientRepository.findAll();
    }

    public List<Inbox> findAllInbox(){
        return inboxRepository.findAll();
    }

    public Optional<Inbox> findAllByUserInbox(Long id){
        return inboxRepository.findAllById(id);
    }

    public Optional<Credit> findCreditByUser(String id){
        return creditRepository.findAllByEmail(id);
    }

    public boolean validateEmail(String username) {
        Boolean a = (clientRepository.findByEmail(username) ==null)? false:true;
        return (a);
    }

}
