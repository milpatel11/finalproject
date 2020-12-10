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
public class Inbox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=2, max = 10, message = "length should be beetwen 2 to 10 letters")
    private String sender;

    @NotBlank
    @Size(min=2, max = 10, message = "length should be beetwen 2 to 10 letters")
    private String receiver;

    @NotBlank
    @Size(min=2, max = 100, message = "length should be beetwen 2 to 100 letters")
    private String subject;

    @NotBlank
    //@Size(min=2, max = 10, message = "length should be beetwen 2 to 10 letters")
    private String message;

    @NotBlank
    @Size(min=2, message = "length should be beetwen 2 to 10 letters")
    private Date time;

    public Inbox(){

    }

    public Inbox(@NotBlank @Size(min = 2, max = 10, message = "length should be beetwen 2 to 10 letters") String sender, @NotBlank @Size(min = 2, max = 10, message = "length should be beetwen 2 to 10 letters") String receiver, @NotBlank @Size(min = 2, max = 100, message = "length should be beetwen 2 to 100 letters") String subject, @NotBlank String message, @NotBlank @Size(min = 2, message = "length should be beetwen 2 to 10 letters") Date time) {
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.message = message;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Inbox{" +
                "id=" + id +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", time=" + time +
                '}';
    }
}
