package com.jokes.jokes_book.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FuturisticJokesData {
    private static List<String> futuristicJokes = new ArrayList<>();

    static {
        futuristicJokes.add("Why did the AI break up with its girlfriend? It needed more space!");
        futuristicJokes.add("Why don’t robots ever get lost? Because they always follow the algorithm!");
        futuristicJokes.add("What do you call a spaceship full of smart people? A brainstorm!");
        futuristicJokes.add("Why did the self-driving car get pulled over? It couldn’t handle the traffic laws update!");
        futuristicJokes.add("Why do time travelers make great friends? Because they’re always there for you, before you even need them!");
        futuristicJokes.add("What’s a robot’s favorite type of music? Heavy metal!");
        futuristicJokes.add("Why did the WiFi break up with the computer? Too many connections!");
        futuristicJokes.add("Why did the astronaut bring a ladder to space? Because he wanted to reach new heights!");
        futuristicJokes.add("What do you call an alien with three eyes? An a-liiien!");
        futuristicJokes.add("Why did the quantum physicist refuse to tell a joke? Because it was both funny and not funny at the same time!");
        futuristicJokes.add("How does a robot flirt? By saying, ‘You complete my circuits!’");
        futuristicJokes.add("Why don’t aliens use social media? They don’t want to be followed!");
        futuristicJokes.add("Why was the spaceship so calm? Because it had zero Gs!");
        futuristicJokes.add("What do you call a planet that sings? Neptune-ted!");
        futuristicJokes.add("What’s a robot’s favorite exercise? Circuit training!");
        futuristicJokes.add("Why do aliens never argue? Because they always find common ground!");
        futuristicJokes.add("What’s a hacker’s favorite snack? Cookies… but only if they’re enabled!");
        futuristicJokes.add("Why don’t AI assistants ever get tired? Because they always run on caffeine… and code!");
        futuristicJokes.add("What’s an astronaut’s favorite part of a computer? The space bar!");
        futuristicJokes.add("Why did the scientist break up with the light bulb? Because it wasn’t bright enough for them!");
    }


    public static String getFuturisticJokes() {
        return futuristicJokes.get(ThreadLocalRandom.current().nextInt(0, futuristicJokes.size() - 1));
    }
    //1- pick a random index per joke Math.random size -1?
    //2-  generate random number, get element inside the array using that random number
    //3- remove that element from the array (parse index)
    //4- return that element = string to the cdb
}
