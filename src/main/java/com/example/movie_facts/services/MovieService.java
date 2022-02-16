package com.example.movie_facts.services;


import com.example.movie_facts.models.Movie;
import com.example.movie_facts.repositories.MovieRepository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;



public class MovieService {
    private final MovieRepository mv = new MovieRepository("src\\main\\resources\\imdb-data.csv");
    private final Random ran = new Random();

    public MovieService(){}

    private void fillList(){
        if(mv.getMovieList().size() == 0)
            mv.initFile();
    }

    public String welcomeMSG(){
        String space = "&nbsp";
        return "░▀▄░░▄▀<br>" +
                "▄▄▄██▄▄▄▄▄░▀█▀▐░▌<br>" +
                "█▒░▒░▒░█▀█░░█░▐░▌<br>" +
                "█░▒░▒░▒█▀█░░█░░█<br>" +
                "█▄▄▄▄▄▄███══════<br>" +
                "This application analyses movie data";
    }


    public Movie getFirstMovie(){
        fillList();
        return mv.getMovieList().get(0);
    }

    public Movie getRandomMovie(){
        fillList();
        return mv.getMovieList().get(ran.nextInt(mv.getMovieList().size()));
    }

    public ArrayList<String> getTopTen(){
        fillList();
        ArrayList<String> topTenList = new ArrayList<>();
        ArrayList<Movie> movieList = new ArrayList<>();
        int movieListSize = mv.getMovieList().size();

        for (int i = 0; i < 10; i++) {
            movieList.add(mv.getMovieList().get(ran.nextInt(movieListSize)));
        }

        Collections.sort(movieList);

        for (int i = 0; i < 10; i++) { //grimt men whatever
            topTenList.add(movieList.get(i).toString());
        }

        return topTenList;
    }

    public int howManyAwards(){
        fillList();
        int inc = 0;
        for (Movie movie : mv.getMovieList()) {
            if(movie.hasWonAward())
                inc++;
        }
        return inc;
    }

    public ArrayList<String> filterMovies(char ch,int amount){
        fillList();
        ArrayList<String> movieList = new ArrayList<>();
        String concat = ""+ch;

        for (Movie movie : mv.getMovieList()) {
            if (StringUtils.countOccurrencesOf(movie.getTitle(),concat) == amount)
                movieList.add(movie.toString());
        }

        return movieList;
    }

    public String longestGenre(String g1, String g2){
        fillList();

        int inc1 = 0;
        int inc2 = 0;
        int g1Average = 0;
        int g2Average = 0;

        for (Movie movie : mv.getMovieList()) {

            if(movie.getSubject().matches(g1) && movie.getSubject().matches(g2))
                return "whoops, you cant compare "+g1+" to "+g2+" u lil ape";

            if(movie.getSubject().matches(g1)){
                g1Average += movie.getLength();
                inc1++;
            }
            else if(movie.getSubject().matches(g2)){
                g2Average += movie.getLength();
                inc2++;
            }

        }
        g1Average = g1Average / inc1;
        g2Average = g2Average / inc2;

        if(g1Average>g2Average)
            return g1 + " has the longest average playtime with: " + g1Average + " minutes";
        else
            return g2 + " has the longest average playtime with: " + g2Average + " minutes";
    }





}
