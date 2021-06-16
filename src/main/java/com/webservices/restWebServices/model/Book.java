package com.webservices.restWebServices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Table(name = "bookstore")
public class Book {

    @Id
    private long isbn;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String authorName;

    @Column
    private LocalDate releaseDate;

    @Column
    private Boolean vintage;

    @Column
    private Boolean signed;

    @Column
    private double price;

    public Book() {
    }

    public Book(long isbn, String name, String description, String authorName, LocalDate releaseDate, Boolean vintage,
                Boolean signed, double price) {
        this.isbn = isbn;
        this.name = name;
        this.description = description;
        this.authorName = authorName;
        this.releaseDate = releaseDate;
        this.vintage = vintage;
        this.signed = signed;
        this.price = price;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getVintage() {
        return vintage;
    }

    public void setVintage(Boolean vintage) {
        this.vintage = vintage;
    }

    public Boolean getSigned() {
        return signed;
    }

    public void setSigned(Boolean signed) {
        this.signed = signed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", authorName='" + authorName + '\'' +
                ", releaseDate=" + releaseDate +
                ", vintage=" + vintage +
                ", signed=" + signed +
                ", price=" + price +
                '}';
    }
}
