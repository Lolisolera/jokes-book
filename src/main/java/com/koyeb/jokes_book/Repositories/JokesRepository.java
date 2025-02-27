package com.koyeb.jokes_book.Repositories;

import com.koyeb.jokes_book.Models.Joke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JokesRepository extends JpaRepository <Joke, Long>{
    List<Joke> findByTagContainingIgnoreCase(String tag);
    List<Joke> findByCategoryContainingIgnoreCase(String category);
}


