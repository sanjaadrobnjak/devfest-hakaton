package com.example.backend.models;

public class User {
    private String firstname;
    private String lastname;
    private String password;
    private String username;
    private String type;
    private String address;
    private String subscription;
    private String mail;

    public User(String firstname, String lastname, String password, String username, String type, String address, String subscription,
            String mail) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.username = username;
        this.type = type;
        this.address = address;
        this.subscription = subscription;
        this.mail = mail;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getSubscription() {
        return subscription;
    }
    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    @Override
    public String toString() {
        return "User [firstname=" + firstname + ", lastname=" + lastname + ", password=" + password + ", username="
                + username + ", type=" + type + ", address=" + address + ", subscription=" + subscription + ", mail="
                + mail + "]";
    }

}
