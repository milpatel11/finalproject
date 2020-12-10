//   Assignment 2
//        * Assignment: 2
//        * Author(s):
//        * Student Number:
//        * Date: November 8, 2020
//        * Description: This file sends the captcha
package com.example.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
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


@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rolename;

    @ManyToMany(mappedBy = "roleList", fetch = FetchType.EAGER)
    private List<User> userList = new ArrayList<>();

    public Role(String rolename) {
        this.rolename = rolename;
    }

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String role) {
        this.rolename = role;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Role{" +
                ", rolename='" + rolename + '\'' +
                '}';
    }
}
