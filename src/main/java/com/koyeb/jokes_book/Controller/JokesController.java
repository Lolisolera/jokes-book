package com.koyeb.jokes_book.Controller;

import com.koyeb.jokes_book.Models.*;

import com.koyeb.jokes_book.Repositories.JokeOfTheDayRepository;
import com.koyeb.jokes_book.Repositories.JokesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/jokes")

public class JokesController{
    private JokesRepository jokesRepository;
    private JokeOfTheDayRepository jokeOfTheDayRepository;
    @Autowired
    public JokesController(JokesRepository jokesRepository, JokeOfTheDayRepository jokeOfTheDayRepository) {
        this.jokesRepository = jokesRepository;
        this.jokeOfTheDayRepository = jokeOfTheDayRepository;
    }

    //POST /Jokes
   @PostMapping("/populatedb")
    public String seedDB(@RequestParam(required = false) String count) {
       int counter;
        counter = count != null ? Integer.parseInt(count) : 5;

        if (jokesRepository.count() > 0) {
            return "Jokes table already has jokes entries";
        }

        List<Joke>jokes = new ArrayList<>();
        for (int i = 0; i < counter; i++) {
            Joke futuristicJoke = FuturisticJokesData.getFuturisticJokes();
            Joke darkJoke = DarkJokesData.getDarkJokes();
            Joke geekJoke = GeekJokesData.getGeekJokes();

            jokes.add(darkJoke);
            jokes.add(futuristicJoke);
            jokes.add(geekJoke);
        }

        jokesRepository.saveAll(jokes);
        return String.format("%s jokes were added successfully to the table",
                counter);

    } // end populatedb

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

    // GET /jokes/{tagWord} -> returns any jokes with tag matching that word
    @GetMapping("/search/tag")
    public List<Joke> findJokesByTagWord(@RequestParam String tag){
        return jokesRepository.findByTagContainingIgnoreCase(tag);
    };

    //GET /jokes/{category} -> returns any/all jokes by specific category
    @GetMapping("/search/cat")
    public List<Joke> findJokesByCategory(@RequestParam String category){
        return jokesRepository.findByCategoryContainingIgnoreCase(category);
    }

    // POST : populate the jokes of the day for last 14 days is default amount
    @PostMapping("/populatejokesoftheday")
    public String populateJokesOfTheDay(@RequestParam(required = false) String count) {
        int counter;
        counter = count != null ? Integer.parseInt(count) : 14;

        if (jokeOfTheDayRepository.count() > 0) {
            return "Joke of the day table already has entries";
        }

        List<Joke> allJokes = jokesRepository.findAll(); // gets all the jokes in table
        List<JokeOfTheDay> jokesOfTheDay = new ArrayList<>(); // set up our jokesOfTheDay arraylist
        Random random = new Random();

        for (int i = 0; i < counter; i++) {
            Joke joke = allJokes.get(random.nextInt(allJokes.size())); // gets random joke from allJokes
            JokeOfTheDay jokeOfTheDay = new JokeOfTheDay(); // creating a new joke of the day object
            jokeOfTheDay.setJoke(joke);
            jokeOfTheDay.setDate(LocalDate.now().minusDays(i)); // by default is 14 or count if passed a number
            jokesOfTheDay.add(jokeOfTheDay);
        }

        jokeOfTheDayRepository.saveAll(jokesOfTheDay);
        return String.format("%s joke of the day entries were added successfully to the table",
                counter);
    }

    // GET /joke-of-the-day : get todays joke
    @GetMapping("/joke-of-the-day")
    public JokeOfTheDay getJokeOfTheDay() {
        return jokeOfTheDayRepository.findByDate(LocalDate.now());
    }

    // GET /joke-of-the-day/{date} : get joke by date
    // format for dates is yyyy-MM-dd
    @GetMapping("/joke-of-the-day/{date}")
        public JokeOfTheDay getJokeOfTheDay(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
            return jokeOfTheDayRepository.findByDate(date);
    }

} // end class

