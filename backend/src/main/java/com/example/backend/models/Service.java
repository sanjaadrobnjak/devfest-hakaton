package com.example.backend.models;

public class Service {

    private int id;
    private String senior_username;
    private String description;
    private String address;
    private int price;
    private String name;
    private String helper_username;
    
    public Service(int id, String username, String description, String address, int price, String name, String helper_username) {
        this.id = id;
        this.senior_username = username;
        this.description = description;
        this.address = address;
        this.price = price;
        this.name = name;
        this.helper_username = helper_username;
    }

    public String getSenior_username() {
        return senior_username;
    }

    public void setSenior_username(String senior_username) {
        this.senior_username = senior_username;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String serviceDesc) {
        this.description = serviceDesc;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHelper_username() {
        return helper_username;
    }

    public void setHelper_username(String helper_username) {
        this.helper_username = helper_username;
    }
    
}
