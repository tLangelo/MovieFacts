package com.example.movie_facts.controllers;

import com.example.movie_facts.models.Movie;
import com.example.movie_facts.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class MovieController {
    MovieService ms = new MovieService();

    @GetMapping("/")
    public String index(){
        return ms.welcomeMSG();
    }

    @GetMapping("/getFirst")
    public String firstMovie(){
        return ms.getFirstMovie().toString();
    }

    @GetMapping("/getRandom")
    public String randomMovie(){
        return ms.getRandomMovie().toString();
    }

    @GetMapping("/getTenSortByPopularity")
    public String tenMovies(){  //Lavede return-typen String fordi den ikke ville printe med brackets hvis det var en ArrayList
        return ms.getTopTen().toString();
    }

    @GetMapping("/howManyWonAnAward")
    public String amountOfAwards(){
        return ms.howManyAwards() + " movies have won an award";
    }

    @GetMapping("/filter")
    public String searchByChar(@RequestParam char ch, @RequestParam int amount){ //Same story her som ved "tenMovies()"
        return ms.filterMovies(ch,amount).toString();
    }

    @GetMapping("/longest")
    public String compareGenres(@RequestParam String g1, @RequestParam String g2){
        return ms.longestGenre(g1,g2);
    }
}
