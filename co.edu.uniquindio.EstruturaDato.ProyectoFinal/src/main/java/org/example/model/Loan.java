package org.example.model;

import java.util.Date;

public class Loan {
    private User user;
    private Book book;
    private Date startDate;
    private Date endDate;
    private boolean returned;

    public Loan() {
    }

    public Loan(User user, Book book, Date startDate, Date endDate, boolean returned) {
        this.user = user;
        this.book = book;
        this.startDate = startDate;
        this.endDate = endDate;
        this.returned = returned;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "user=" + user +
                ", book=" + book +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", returned=" + returned +
                '}';
    }
}
