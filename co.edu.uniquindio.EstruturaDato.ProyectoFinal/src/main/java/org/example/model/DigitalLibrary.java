package org.example.model;

import org.example.structures.BinaryTree.BinaryTree;
import org.example.structures.listasSimples.SimpleList;

public class DigitalLibrary {
    private String id;
    private String nameLibrary;
    private String phone;
    private String adrress;
    private String email;
    private BinaryTree<Book> catalog;
    private BinaryTree<User> users;
    private SimpleList<Loan> loans;
    private SimpleList<Message> messages;
    private SimpleList<Rating> ratings;

    public DigitalLibrary() {
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

    public SimpleList<Loan> getLoans() {
        return loans;
    }

    public void setLoans(SimpleList<Loan> loans) {
        this.loans = loans;
    }

    public SimpleList<Message> getMessages() {
        return messages;
    }

    public void setMessages(SimpleList<Message> messages) {
        this.messages = messages;
    }

    public SimpleList<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(SimpleList<Rating> ratings) {
        this.ratings = ratings;
    }

    public void addBook(Book book) {
        if (this.catalog == null) {
            this.catalog = new BinaryTree<>();
        }
        this.catalog.insert(book);
    }

    public void deleteBook(Book book) {
        if (this.catalog == null) {
            throw new NullPointerException("El catalogo es null");
        }
        this.catalog.deleteData(book);
    }

    public void printCatalog() {
        if(this.catalog==null){
            throw new NullPointerException("El catalogo es null");
        }
        this.catalog.inorder();
    }

    public void addUser(User user) {
        if (this.users == null) {
            this.users = new BinaryTree<>();
        }
        this.users.insert(user);
    }

    public void deleteUser(User user) {
        if (this.users == null) {
            throw new NullPointerException("El arbol de usuarios es null");
        }
        User userAux = this.users.search(user);
        if(userAux!=null){
            this.users.deleteData(user);
        }else{
            System.out.println("usuario no existe en el arbol de usuarios");
        }

    }

    public void updateUser(User user) {
        if (this.users == null) {
            throw new NullPointerException("El arbol de usuarios es null");
        }
        User userAux = this.users.search(user);
        if(userAux!=null){
            userAux.setFirstName(user.getFirstName());
            userAux.setLastName(user.getLastName());
            userAux.setEmail(user.getEmail());
            userAux.setPhone(user.getPhone());
            userAux.setAddress(user.getAddress());
            userAux.setIdentificacion(user.getIdentificacion());
            userAux.setPassword(user.getPassword());
        }else{
            throw new NullPointerException("El usuario no existe en el arbol de usuarios");
        }
    }

    public void printUsers() {
        if(this.users==null){
            throw new NullPointerException("El arbol de usuarios es null");
        }
        this.users.inorder();
    }

}
