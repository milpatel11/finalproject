//   Assignment 2
//        * Assignment: 2
//        * Author(s):
//        * Student Number:
//        * Date: November 8, 2020
//        * Description: User Details Service lamp
package com.example.demo.conf;

import com.example.demo.models.User;
import com.example.demo.repos.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private ClientRepository clientRepository;

    @Autowired
    public UserDetailsServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //User user = clientRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User: " + email + " not found"));

        return null;
    }
}