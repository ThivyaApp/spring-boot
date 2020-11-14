package com.springboot.centreequestre.model;
import javax.persistence.*;

@Entity
@Table(name = "users")

public class User {

    private long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String num;
    private String licensenum;
    private String usertype;

    public User() {}

    public User(String username, String password, String firstname, String lastname, String num, String licensenum, String usertype) {
        super();

        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.num = num;
        this.licensenum = licensenum;
        this.usertype = usertype;
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

    @Column(name = "firstname")
    public String getFirstname () {
        return firstname;
    }
    public void setFirstname (String firstname){
        this.firstname = firstname;
    }

    @Column(name = "lastname")
    public String getLastname () {
        return lastname;
    }
    public void setLastname (String lastname){
        this.lastname = lastname;
    }

    @Column(name = "num")
    public String getNum() {return num;}
    public void setNum (String num){this.num = num; }

    @Column(name = "licensenum")
    public String getLicensenum() {return licensenum;}
    public void setLicensenum (String licensenum){this.licensenum = licensenum; }

    @Column(name = "usertype")
    public String getUsertype() {return usertype;}
    public void setUsertype (String usertype){this.usertype = usertype; }

}
