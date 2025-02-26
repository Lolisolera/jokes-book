package com.jokes.jokes_book.Repositories;

import com.jokes.jokes_book.Models.Joke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JokesRepository extends JpaRepository <Joke, Long>{
}
