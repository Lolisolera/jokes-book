package com.jokes.jokes_book.Controller;

import com.jokes.jokes_book.Models.FuturisticJokesData;
import com.jokes.jokes_book.Models.Joke;
import com.jokes.jokes_book.Repositories.JokesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

        // for loop from i 0 - 19
       // return futuristicJoke[i]

        jokesRepository.saveAll(jokes);
        return String.format("%s jokes were added successfully to the table",
                counter);

    } // populatedb

    // DELETE on jokes/ -> delete ALL jokes in table
    @DeleteMapping
    public String deleteAllJokes() {
        try {
            if (jokesRepository.count() == 0){
                throw new IllegalArgumentException();
            }
            jokesRepository.deleteAll();
            return "All jokes have been deleted from table";
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
            return "The jokes table is already empty";
        }
    }

    // DELETE on jokes/{id} => should delete jokes with id
    @DeleteMapping("/{jokeId}")
    public String deleteById(@PathVariable(required = true) Long jokeId) {
        Joke target = jokesRepository.findById(jokeId).get();
        jokesRepository.delete(target);

        return String.format("Record with id: %d has been " +
                "successfully " +
                "deleted", jokeId);
    }

    // GET /jokes -> return all jokes
    @GetMapping
    public List<Joke> getAllJokes() {
        return jokesRepository.findAll();
    }

    // GET /jokes/{id}
    @GetMapping("/{jokeId}")
    public Optional<Joke> getJokeById(@PathVariable(required = true) Long jokeId){
        return jokesRepository.findById(jokeId);
    };

    // POST /jokes -> creates a new joke into table
    @PostMapping()
    public Joke createJoke(@RequestBody Joke joke) {
        jokesRepository.save(joke);
        return joke;
    }

    //

} // end class

