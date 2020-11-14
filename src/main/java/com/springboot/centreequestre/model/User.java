package com.springboot.centreequestre.model;
import javax.persistence.*;

@Entity
@Table(name = "users")

public class User {


    private long id;
    private String username;
    private String password;
    private String firstName;
    private String secondName;
    private String num;
    private String licenseNum;
    private String userType;

    public User() {}

    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId () {
        return id;
    }
    public void setId (long id){this.id = id;}

    @Column(name = "username")
    public String getUsername () {
        return username;
    }
    public void setUsername (String username){
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword () {return password;}
    public void setPassword (String password){this.password = password; }

    @Column(name = "firstName")
    public String getFirstName () {
        return firstName;
    }
    public void setFirstName (String firstName){
        this.firstName = firstName;
    }

    @Column(name = "secondName")
    public String getSecondName () {
        return secondName;
    }
    public void setSecondName (String secondName){
        this.secondName = secondName;
    }

    @Column(name = "num")
    public String getNum() {return num;}
    public void setNum (String num){this.num = num; }

    @Column(name = "licensenum")
    public String getLicenseNum() {return licenseNum;}
    public void setLicenseNum (String licenseNum){this.licenseNum = licenseNum; }

    @Column(name = "userType")
    public String getUserType() {return userType;}
    public void setUserType (String userType){this.userType = userType; }

}
