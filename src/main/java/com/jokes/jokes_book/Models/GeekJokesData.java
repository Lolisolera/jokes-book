package com.jokes.jokes_book.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class GeekJokesData {
    private static List<String> geekJokes = new ArrayList<>();
    private static final List<String> authors = List.of("Code Ninja", "Bug Hunter", "Binary Bard", "Syntax Samurai");
    private static final List<String> tags = List.of("Programming, Code, Tech", "AI, Computers", "Databases, SQL, Relationships", "Quantum, Future, Space", "Sci-Fi, Debugging, Errors");


    private static final AtomicInteger jokeIndex = new AtomicInteger(0);

    static{
        geekJokes.add("Why do programmers prefer dark mode? Because light attracts bugs!");
        geekJokes.add("Why do Java developers wear glasses? Because they don’t C#!");
        geekJokes.add("Why did the developer go broke? Because he used up all his cache!");
        geekJokes.add("How do you comfort a JavaScript bug? You console it!");
        geekJokes.add("Why was the SQL query so sad? It had too many joins but no relationships!");
        geekJokes.add("There are 10 types of people in this world... Those who understand binary and those who don’t!");
        geekJokes.add("Why did the Python programmer get rejected at the bar? Because he had too many 'indentation errors' in his pickup lines!");
        geekJokes.add("Why did the computer catch a cold? Because it left its Windows open!");
        geekJokes.add("Why did the Wi-Fi break up with the Ethernet cable? Because it felt too restricted!");
        geekJokes.add("Why was the math book sad? Because it had too many problems!");
        geekJokes.add("Why did the function stop calling its friends? Because it had too many arguments!");
        geekJokes.add("What do you call 8 hobbits? A hobbyte!");
        geekJokes.add("Why don’t robots ever get scared? Because they have nerves of steel!");
        geekJokes.add("Why did the AI break up with its girlfriend? Because she was acting too human!");
        geekJokes.add("What’s a programmer’s favorite hangout place? Foo Bar!");
        geekJokes.add("Why do engineers confuse Halloween and Christmas? Because Oct 31 == Dec 25!");
        geekJokes.add("Why did the coder quit his job? Because he didn’t get arrays!");
        geekJokes.add("Why do computer scientists hate nature? Because it has too many bugs!");
        geekJokes.add("What did the Java code say to the C++ code? 'You’ve got too many issues… let’s decompile our differences!'");
        geekJokes.add("Why was the web developer so bad at relationships? Because he always tried to resolve everything asynchronously!");

    }

    public static Joke getGeekJokes() {
        int index = jokeIndex.getAndUpdate(i -> (i + 1) % geekJokes.size());
        String jokeText = geekJokes.get(index);
        int rating = ThreadLocalRandom.current().nextInt(1, 11); // will give a random rating 1-10
        String author = authors.get(ThreadLocalRandom.current().nextInt(authors.size()));
        String tag = tags.get(ThreadLocalRandom.current().nextInt(tags.size()));
        String category = "Geek";
        return new Joke(jokeText, rating, author, tag, category);
    }



}
