package com.example.winify.cvsi.dto.templates.request;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Artemie on 01.07.2016.
 */
public class AuthorizationClientRequest implements Serializable{

    private String email;
    private String password;
    private String phone;
    private String userName;
    private String name;
    private String surname;
    private Long createdDate;

    public AuthorizationClientRequest(String email, String password, String phone, String userName, String name, String surname, Long createdDate) {
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userName = userName;
        this.name = name;
        this.surname = surname;
        this.createdDate = createdDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }
}
