package com.example.demo.repos;//   Assignment 2
//        * Assignment: 2
//        * Author(s):
//        * Student Number:
//        * Date: November 8, 2020
//        * Description: This file sends the captchapackage com.example.demo.repos;

import com.example.demo.models.Credit;
import com.example.demo.models.Inbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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


@Repository
public interface CreditRepository extends JpaRepository<Credit,Long> {

    Optional<Credit> findAllByEmail(String id);

    Optional<Credit> findCreditsByEmail(String email);
}
