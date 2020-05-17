package com.manisharana.moviedetailsservice.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

    private String id;
    private String title;
    private String overview;

    @JsonProperty("release_date")
    private String releaseDate;

    Movie() {
    }

    public Movie(String id, String title, String overview, String releaseDate) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
