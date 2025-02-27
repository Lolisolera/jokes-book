package com.jokes.jokes_book.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class DarkJokesData {
    private static List<String> darkJokes = new ArrayList<>();
    private static final List<String> authors = List. of("AI Bot", "Dark Guru", "Twisted Comedian", "Dart Arts Kid", "Welcome to the dark side");
    private static final List<String> tags = List.of("Dark, Morbid, Twisted", "Edgy, Offensive", "Black, Satire", "Ironic, Controversial, Gallows");
    private static final AtomicInteger jokeIndex = new AtomicInteger(0);

    static {
        darkJokes.add("Why don’t graveyards ever get overcrowded? Because people are dying to get in!");
        darkJokes.add("Why did the orphan bring a ladder to school? To reach their parent-teacher conference!");
        darkJokes.add("Why don’t cannibals eat clowns? Because they taste funny!");
        darkJokes.add("What’s the hardest part about playing chess with a zombie? Trying to stop them from eating the pieces!");
        darkJokes.add("Why don’t skeletons fight each other? They don’t have the guts!");
        darkJokes.add("Why did the man bring a knife to the party? Because it was a cutting-edge event!");
        darkJokes.add("I told my wife I wanted to be cremated… She made an appointment for next Tuesday!");
        darkJokes.add("Why don’t ghosts apply for jobs? Because they have no body to interview!");
        darkJokes.add("Why did the scarecrow win an award? Because he was outstanding in his field… unlike his neighbor, who disappeared mysteriously!");
        darkJokes.add("Why did the executioner break up with his girlfriend? He needed a clean cut!");
        darkJokes.add("What’s the worst part about getting hit by a train? You can’t even complain about it afterward!");
        darkJokes.add("Why don’t serial killers use social media? They already follow too many people!");
        darkJokes.add("I got fired from my job at the cemetery… Apparently, I wasn’t doing a grave job!");
        darkJokes.add("Why did the man bring a ladder to the bar? Because he heard the drinks were on the house!");
        darkJokes.add("Why did the vampire break up with his girlfriend? Because she gave him too much space – and he needed blood!");
        darkJokes.add("I have a joke about construction workers… But it’s still under development, just like that collapsed building!");
        darkJokes.add("Why do hospitals have so many doors? Because patients tend to leave unexpectedly!");
        darkJokes.add("Why did the doctor bring a scalpel to the dinner table? He wanted to make a quick incision!");
        darkJokes.add("Why do graveyards have fences? Because people are dying to get out too!");
        darkJokes.add("What did the undertaker say before closing the casket? 'That's a wrap!'");
    }
    public static Joke getDarkJokes() {
        int index = jokeIndex.getAndUpdate(i -> (i + 1) % darkJokes.size());
        String jokeText = darkJokes.get(index);
        int rating = ThreadLocalRandom.current().nextInt(1, 11); // will give a random rating 1-10
        String author = authors.get(ThreadLocalRandom.current().nextInt(authors.size()));
        String tag = tags.get(ThreadLocalRandom.current().nextInt(tags.size()));
        String category = "Dark";
        return new Joke(jokeText, rating, author, tag, category);
    }
}
