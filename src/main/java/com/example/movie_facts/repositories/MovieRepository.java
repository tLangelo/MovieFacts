package com.example.movie_facts.repositories;

import com.example.movie_facts.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieRepository {
    //This class should read file:imdb-data.csv & create Movie objects of the data

    private Scanner sc;
    private File file;
    private final ArrayList<Movie> movieList;

    public MovieRepository(String filePath){
        file = new File(filePath);
        movieList = new ArrayList<>();

        try{
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void initFile(){

        String line = sc.nextLine();

        while(sc.hasNext()) {
            String currLine = sc.nextLine();
            String[] splitLine = currLine.split(";");

            movieList.add(createMovie(splitLine));
        }
    }

    private Movie createMovie(String[] data){
        int year = Integer.parseInt(data[0]);
        int length = Integer.parseInt(data[1]);
        String title = data[2];
        String subject = data[3];
        int popularity = Integer.parseInt(data[4]);
        String hasWonAward = data[5];

        return new Movie(year,length,title,subject,popularity,hasWonAward);
    }

    public ArrayList<Movie> getMovieList(){
        return movieList;
    }

}
