package com.koyeb.jokes_book.Repositories;

import com.koyeb.jokes_book.Models.JokeOfTheDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface JokeOfTheDayRepository extends JpaRepository<JokeOfTheDay, Long> {
    JokeOfTheDay findByDate(LocalDate date);
}
