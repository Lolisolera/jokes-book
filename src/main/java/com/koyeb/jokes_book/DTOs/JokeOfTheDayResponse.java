package com.koyeb.jokes_book.DTOs;

import com.koyeb.jokes_book.Models.Joke;

public class JokeOfTheDayResponse {

    private Joke joke;

    public JokeOfTheDayResponse(Joke joke) {
        this.joke = joke;
    }

    public Joke getJoke() {
        return joke;
    }

    public void setJoke(Joke joke) {
        this.joke = joke;
    }
}
