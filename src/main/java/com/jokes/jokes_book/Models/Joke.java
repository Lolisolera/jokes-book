package com.jokes.jokes_book.Models;

import jakarta.persistence.*;


@Entity
@Table(name =  "jokes")
public class Joke {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String joke;
    private int rating;
    private String author;
    private String tag;


   /*@OneToOne(mappedBy = "jokes", cascade = CascadeType.ALL)
    @Enumerated(EnumType.ORDINAL)
    private Category category;

    */



    public Joke() {
    }

    public Joke(String joke) {
        this.joke = joke;
    }

    public Joke(String joke, int rating, String author, String tag) {
        this.joke = joke;
        this.rating = rating;
        this.author = author;
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
