package org.example.model;

import org.example.model.enums.UserType;

public class User extends Person {
    private String id;
    private String password;
    private Enum<UserType> userType;

    public User() {

    }

    public User(String id, String firstName, String lastName, String email, String phone, String address, String id1, String password, Enum<UserType> userType) {
        super(id, firstName, lastName, email, phone, address);
        this.id = id1;
        this.password = password;
        this.userType = userType;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Enum<UserType> getUserType() {
        return userType;
    }

    public void setUserType(Enum<UserType> userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }
}
