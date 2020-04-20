package com.manisharana.moviecatalogservice.models;

public class CatalogItem {

    private String movieName;
    private String movieDetail;
    private int movieRating;

    public CatalogItem(String movieName, String movieDetail, int movieRating) {
        this.movieName = movieName;
        this.movieDetail = movieDetail;
        this.movieRating = movieRating;
    }


    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDetail() {
        return movieDetail;
    }

    public void setMovieDetail(String movieDetail) {
        this.movieDetail = movieDetail;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }
}
