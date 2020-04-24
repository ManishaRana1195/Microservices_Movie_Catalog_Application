package com.manisharana.ratingsdataservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingResource {

    @RequestMapping("/{movieId}")
    public Rating getRatingsByMovieId(@PathVariable("movieId") String movieId) {
        return new Rating("4567", "4");
    }

    @RequestMapping("/users/{userId}")
    public UserRating getRatingByUserId(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(new Rating("6557", "5"), new Rating("7874", "7"));
        return new UserRating(ratings);
    }
}
