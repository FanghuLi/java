package com.lifanghu.model;

public class User {

    private int id;
    private String userName;
    private int userAge;
    private String userAddress;
    

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
