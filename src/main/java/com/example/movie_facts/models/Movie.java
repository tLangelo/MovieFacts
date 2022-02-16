package com.example.movie_facts.models;



public class Movie implements Comparable<Movie>{
    private int year;
    private int length;
    private String title;
    private String subject;
    private int popularity;
    private boolean hasWonAward;


    public Movie(int year, int length, String title, String subject, int popularity, String hasWonAward) {
        this.year = year;
        this.length = length;
        this.title = title;
        this.subject = subject;
        this.popularity = popularity;
        if(hasWonAward.equals("Yes"))
            this.hasWonAward = true;
        else
            this.hasWonAward = false;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public String getSubject() {
        return subject;
    }

    public boolean hasWonAward() {
        return hasWonAward;
    }

    @Override
    public String toString() {


        String space = "&nbsp";
        return  space + "Year: " + year +
                space + " |" + space + "Length: " + length +
                space + " |" + space + "Title: " + title +
                space + " |"+ space + "Subject: " + subject +
                space + " |"+ space + "Popularity: " + popularity +
                space + " |"+ space + "Awards: " + hasWonAward + "<br>";
    }

    @Override
    public int compareTo(Movie o) {
        if(popularity == o.popularity)
            return 0;
        else if(popularity > o.popularity)
            return 1;
        else
            return -1;
    }
}
