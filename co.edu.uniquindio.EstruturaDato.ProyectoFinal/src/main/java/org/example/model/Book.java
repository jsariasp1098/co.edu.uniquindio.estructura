package org.example.model;

import org.example.model.enums.Status;

import java.util.List;

public class Book implements Comparable <Book>{
    private String id;
    private String title;
    private String author;
    private String genre;
    private String year;
    private Enum<Status> status;
    private List<Rating> ratings;

    public Book() {
    }

    public Book(String id, String title, String author, String genre, String year, Enum<Status> status, List<Rating> ratings) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.status = status;
        this.ratings = ratings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Enum<Status> getStatus() {
        return status;
    }

    public void setStatus(Enum<Status> status) {
        this.status = status;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", year='" + year + '\'' +
                ", status=" + status +
                ", ratings=" + ratings +
                '}';
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book otro = (Book) o;
        return id.equals(otro.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
