//   Assignment 2
//        * Assignment: 2
//        * Author(s):
//        * Student Number:
//        * Date: November 8, 2020
//        * Description: This file sends the captcha
package com.example.demo.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
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


@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=2, max = 10, message = "length should be beetwen 2 to 10 letters")
    private String firstName;

    @NotBlank
    @Size(min=2, max = 10, message = "length should be beetwen 2 to 10 letters")
    private String lastName;

    @NotBlank
    @Size(min=2, max = 100, message = "length should be beetwen 2 to 100 letters")
    private String address;

    @NotBlank
    //@Size(min=2, max = 10, message = "length should be beetwen 2 to 10 letters")
    private String password;

    @NotEmpty(message = "e-mail can't be empty")
    @Email(regexp = "^(.+)@(.+)$", message = "invalid e-mail pattern")
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roleList= new ArrayList();

    @NotBlank
    @Size(min=2, message = "length should be beetwen 2 to 10 letters")
    private Date dob;


    public User() {
    }

    public User(String firstName, String lastName, String address, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.password = password;
        this.email = email;
        this.dob = new Date();
    }

    public User(String firstName, String lastName, String address, String password, String email, List<Role> roleList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.password = password;
        this.email = email;
        this.roleList = roleList;
        this.dob = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + firstName + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roleList=" + roleList +
                '}';
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        String ROLE_PREFIX = "ROLE_";

        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        for(Role role:roleList){
            list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getRolename()));
        }
        return list;
    }
}