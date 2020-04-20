package com.manisharana.moviecatalogservice.models;

/*It is similar to class in movie details service,
 we need to un-marshall the response from movie-details service*/
public class Movie {

    private String id;
    private String name;
    private String description;

    Movie(){}

    public Movie(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
