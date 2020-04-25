package com.manisharana.moviedetailsservice.resources;

public class Movie {

    private String id;
    private String name;
    private String description;
    private String directorName;
    private int yearOfRelease;

    public Movie(String id, String name, String description, String directorName, int yearOfRelease) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.directorName = directorName;
        this.yearOfRelease = yearOfRelease;
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

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

}
