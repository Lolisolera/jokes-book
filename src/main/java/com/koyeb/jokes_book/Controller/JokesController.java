package com.koyeb.jokes_book.Controller;

import com.koyeb.jokes_book.DTOs.JokeOfTheDayResponse;
import com.koyeb.jokes_book.Models.*;
import com.koyeb.jokes_book.Repositories.JokeOfTheDayRepository;
import com.koyeb.jokes_book.Repositories.JokesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/jokes")
public class JokesController {

    private final JokesRepository jokesRepository;
    private final JokeOfTheDayRepository jokeOfTheDayRepository;

    @Autowired
    public JokesController(JokesRepository jokesRepository, JokeOfTheDayRepository jokeOfTheDayRepository) {
        this.jokesRepository = jokesRepository;
        this.jokeOfTheDayRepository = jokeOfTheDayRepository;
    }

    @PostMapping("/populatedb")
    public String seedDB(@RequestParam(required = false) String count) {
        int counter = count != null ? Integer.parseInt(count) : 5;

        if (jokesRepository.count() > 0) {
            return "Jokes table already has jokes entries";
        }

        List<Joke> jokes = new ArrayList<>();
        for (int i = 0; i < counter; i++) {
            jokes.add(DarkJokesData.getDarkJokes());
            jokes.add(FuturisticJokesData.getFuturisticJokes());
            jokes.add(GeekJokesData.getGeekJokes());
        }

        jokesRepository.saveAll(jokes);
        return String.format("%s jokes were added successfully to the table", counter);
    }

    @DeleteMapping
    public String deleteAllJokes() {
        if (jokesRepository.count() == 0) {
            return "The jokes table is already empty";
        }
        jokesRepository.deleteAll();
        return "All jokes have been deleted from table";
    }

    @DeleteMapping("/{jokeId}")
    public String deleteById(@PathVariable Long jokeId) {
        Optional<Joke> jokeOpt = jokesRepository.findById(jokeId);
        if (jokeOpt.isPresent()) {
            jokesRepository.delete(jokeOpt.get());
            return String.format("Record with id: %d has been successfully deleted", jokeId);
        } else {
            return String.format("No joke found with id: %d", jokeId);
        }
    }

    @GetMapping
    public List<Joke> getAllJokes() {
        return jokesRepository.findAll();
    }

    @GetMapping("/{jokeId}")
    public Optional<Joke> getJokeById(@PathVariable Long jokeId) {
        return jokesRepository.findById(jokeId);
    }

    @PostMapping
    public Joke createJoke(@RequestBody Joke joke) {
        jokesRepository.save(joke);
        return joke;
    }

    @GetMapping("/search/tag")
    public List<Joke> findJokesByTagWord(@RequestParam String tag) {
        return jokesRepository.findByTagContainingIgnoreCase(tag);
    }

    @GetMapping("/search/cat")
    public List<Joke> findJokesByCategory(@RequestParam String category) {
        return jokesRepository.findByCategoryContainingIgnoreCase(category);
    }

    @PostMapping("/populatejokesoftheday")
    public String populateJokesOfTheDay(@RequestParam(required = false) String count) {
        int counter = count != null ? Integer.parseInt(count) : 14;

        if (jokeOfTheDayRepository.count() > 0) {
            return "Joke of the day table already has entries";
        }

        List<Joke> allJokes = jokesRepository.findAll();
        List<JokeOfTheDay> jokesOfTheDay = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < counter; i++) {
            Joke joke = allJokes.get(random.nextInt(allJokes.size()));
            JokeOfTheDay jokeOfTheDay = new JokeOfTheDay();
            jokeOfTheDay.setJoke(joke);
            jokeOfTheDay.setDate(LocalDate.now().minusDays(i));
            jokesOfTheDay.add(jokeOfTheDay);
        }

        jokeOfTheDayRepository.saveAll(jokesOfTheDay);
        return String.format("%s joke of the day entries were added successfully to the table", counter);
    }

    // This now returns a DTO wrapper object
    @GetMapping("/joke-of-the-day")
    public JokeOfTheDayResponse getJokeOfTheDay() {
        JokeOfTheDay jokeOfTheDay = jokeOfTheDayRepository.findByDate(LocalDate.now());

        if (jokeOfTheDay == null || jokeOfTheDay.getJoke() == null) {
            return new JokeOfTheDayResponse(new Joke("Joke unavailable today", "", ""));
        }

        return new JokeOfTheDayResponse(jokeOfTheDay.getJoke());
    }

    @GetMapping("/joke-of-the-day/{date}")
    public JokeOfTheDay getJokeOfTheDay(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return jokeOfTheDayRepository.findByDate(date);
    }
}
