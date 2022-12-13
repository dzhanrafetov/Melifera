package com.beesdev.shop.model;

import javax.persistence.*;
import java.time.LocalDateTime;
//prichinata da nqma setteri immutability
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String mail;
    private LocalDateTime creationTime;
    private String phoneNum;
    private Boolean isActive;

public User(){

}

    public User(Long id, String firstName, String lastName, String mail, LocalDateTime creationTime, String phoneNum, Boolean isActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.creationTime = creationTime;
        this.phoneNum = phoneNum;
        this.isActive = isActive;
    }

    public User(Long id, String firstName, String lastName, String mail, LocalDateTime creationTime, String phoneNum ){
this.id=id;
this.firstName=firstName;
this.lastName=lastName;
this.mail=mail;
this.creationTime=creationTime;
this.phoneNum=phoneNum;
    }



    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getFirstName(){
        return  this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public String getMail(){
        return this.mail;
    }
    public void setMail(String mail){
        this.mail=mail;
    }
    public LocalDateTime getCreationTime(){
        return this.creationTime;
    }
    public void setCreationTime(LocalDateTime creationTime){
        this.creationTime=creationTime;
    }
    public String getPhoneNum(){
        return this.phoneNum;
    }
    public void setPhoneNum(String phoneNum){
        this.phoneNum=phoneNum;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString(){
        return this.firstName+"" +
                " "+this.lastName+" " +
                ""+this.mail+" "+" "+this.creationTime+" "+ this.phoneNum;
    }
}

//
////
////      @ManyToMany(fetch=FetchType.LAZY , cascade =[ CascadeType.ALL])
////        @JoinTable(name = "user_role",
////         joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
////            inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")])
//////FetchType.LAZY-
////      //DOKATO ne vikna ROLE-rolqta na usera -Rolerolqta ne se inicializirva
////      //
////        val roles:List<Role>?
//
//
////        val commentedAds:Long,
////        val postCode:String,
//
//
//)