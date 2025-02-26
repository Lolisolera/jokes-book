package com.jokes.jokes_book.Controller;

import com.jokes.jokes_book.Models.FuturisticJokesData;
import com.jokes.jokes_book.Models.Joke;
import com.jokes.jokes_book.Repositories.JokesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/jokes")


public class JokesController{
    private JokesRepository jokesRepository;
    @Autowired
    public JokesController(JokesRepository jokesRepository) {
        this.jokesRepository = jokesRepository;


    }

    //POST /Jokes
   @PostMapping("/populatedb")
    public String seedDB(@RequestParam(required = false) String count) {
       int counter;
        counter = count != null ? Integer.parseInt(count) : 5;

        if (jokesRepository.count() > 0) {
            return "Jokes tables already has jokes entries";
        }
        //limit amount of jokes cited in db to 20

        List<Joke>jokes = new ArrayList<>();
        for (int i = 0; i < counter; i++) {
            String futuristicJoke = FuturisticJokesData.getFuturisticJokes();
            jokes.add(new Joke(futuristicJoke));


        }
        jokesRepository.saveAll(jokes);
        return String.format("%s jokes were added successfully to the table",
                counter);

    }


}

