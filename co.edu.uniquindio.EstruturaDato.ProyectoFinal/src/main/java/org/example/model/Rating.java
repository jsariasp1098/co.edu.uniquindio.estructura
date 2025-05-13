package org.example.model;

public class Rating {
    private User user;
    private Book book;
    private int rating;
    private String comment;

    public Rating() {
    }

    public Rating(User user, Book book, int rating, String comment) {
        this.user = user;
        this.book = book;
        this.rating = rating;
        this.comment = comment;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "user=" + user +
                ", book=" + book +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
}
