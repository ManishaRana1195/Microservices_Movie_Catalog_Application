package com.manisharana.moviecatalogservice.models;

public class CatalogItem {

    private Movie movie;
    private int movieRating;

    public CatalogItem(Movie movie, int movieRating) {
        this.movie = movie;
        this.movieRating = movieRating;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }
}
