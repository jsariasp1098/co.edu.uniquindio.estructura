package org.example.model;

import org.example.model.enums.UserType;

public class User extends Person implements Comparable <User> {
    private String id;
    private String password;
    private Enum<UserType> userType;

    public User() {

    }

    public User(String identificacion, String firstName, String lastName, String email, String phone, String address, String id1, String password, Enum<UserType> userType) {
        super(identificacion, firstName, lastName, email, phone, address);
        this.id = id1;
        this.password = password;
        this.userType = userType;
    }


    public String getIdentificacion() {
        return id;
    }


    public void setIdentificacion(String identificacion) {
        this.id = identificacion;
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
        return "User{"  + super.toString() +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }

    @Override
    public int compareTo(User other) {
        // Por ejemplo ordenas por id:
        return this.id.compareTo(other.id);
    }
}
