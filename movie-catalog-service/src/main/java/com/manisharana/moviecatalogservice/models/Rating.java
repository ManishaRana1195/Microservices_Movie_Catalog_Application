package com.manisharana.moviecatalogservice.models;

/* Adding the model for now, for hardcoding user rating*/
public class Rating {

    private String movieId;
    private int movieRating;

    Rating() {
    }

    public Rating(String movieId, int movieRating) {
        this.movieId = movieId;
        this.movieRating = movieRating;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }
}
