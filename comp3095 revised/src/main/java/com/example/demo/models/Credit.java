package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
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


@Entity
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=2, max = 10, message = "length should be beetwen 2 to 10 letters")
    private String cardNumber;

    @NotBlank
    @Size(min=2, max = 10, message = "length should be beetwen 2 to 10 letters")
    private String expiry;

    @NotBlank
    @Size(min=2, max = 100, message = "length should be beetwen 2 to 100 letters")
    private String name;

    @NotBlank
    @Size(min=2, max = 100, message = "length should be beetwen 2 to 100 letters")
    private String email;


    public Credit(){

    }

    public Credit(String cardNumber, String expiry, String name, String email) {
        this.cardNumber = cardNumber;
        this.expiry = expiry;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Inbox{" +
                "id=" + id +
                ", sender='" + cardNumber + '\'' +
                ", receiver='" + expiry + '\'' +
                ", subject='" + name + '\''+
                '}';
    }
}
