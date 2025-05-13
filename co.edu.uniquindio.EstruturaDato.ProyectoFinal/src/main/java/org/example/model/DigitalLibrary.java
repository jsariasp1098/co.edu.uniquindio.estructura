package org.example.model;

import org.example.util.BinaryTree.BinaryTree;

public class DigitalLibrary {
    private String id;
    private String nameLibrary;
    private String phone;
    private String adrress;
    private String email;
    private BinaryTree<Book> catalog;
    private BinaryTree<User> users;

    public DigitalLibrary() {
    }

    public DigitalLibrary(String id, String nameLibrary, String phone, String adrress, String email, BinaryTree<Book> catalog, BinaryTree<User> users) {
        this.id = id;
        this.nameLibrary = nameLibrary;
        this.phone = phone;
        this.adrress = adrress;
        this.email = email;
        this.catalog = catalog;
        this.users = users;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameLibrary() {
        return nameLibrary;
    }

    public void setNameLibrary(String nameLibrary) {
        this.nameLibrary = nameLibrary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdrress() {
        return adrress;
    }

    public void setAdrress(String adrress) {
        this.adrress = adrress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BinaryTree<Book> getCatalog() {
        return catalog;
    }

    public void setCatalog(BinaryTree<Book> catalog) {
        this.catalog = catalog;
    }

    public BinaryTree<User> getUsers() {
        return users;
    }

    public void setUsers(BinaryTree<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "DigitalLibrary{" +
                "id='" + id + '\'' +
                ", nameLibrary='" + nameLibrary + '\'' +
                ", phone='" + phone + '\'' +
                ", adrress='" + adrress + '\'' +
                ", email='" + email + '\'' +
                ", catalog=" + catalog +
                ", users=" + users +
                '}';
    }
}
