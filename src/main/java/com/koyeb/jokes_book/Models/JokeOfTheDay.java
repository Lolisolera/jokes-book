package com.koyeb.jokes_book.Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "joke_of_the_day")
public class JokeOfTheDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "joke_id", referencedColumnName = "id")
    private Joke joke;

    @Column(name = "date")
    private LocalDate date;

    public Joke getJoke() {
        return joke;
    }

    public void setJoke(Joke joke) {
        this.joke = joke;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
