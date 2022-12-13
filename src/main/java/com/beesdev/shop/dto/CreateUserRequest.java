package com.beesdev.shop.dto;

import java.time.LocalDateTime;

public class CreateUserRequest {


    private Long id;
    private String firstName;
    private String lastName;
    private String mail;
    private LocalDateTime creationTime;
    private String phoneNum;

    public CreateUserRequest() {
    }

    public CreateUserRequest(Long id,String firstName, String lastName, String mail, LocalDateTime creationTime, String phoneNum) {
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.creationTime = creationTime;
        this.phoneNum = phoneNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
