package com.beesdev.shop.dto;

import java.time.LocalDateTime;

public class UpdateUserRequest {

    private String firstName;
    private String lastName;
    private String mail;
    private LocalDateTime updateTime;
    private String phoneNum;

    public UpdateUserRequest() {
    }

    public UpdateUserRequest(String firstName, String lastName, String mail, LocalDateTime updateTime, String phoneNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.updateTime = updateTime;
        this.phoneNum = phoneNum;
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

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
