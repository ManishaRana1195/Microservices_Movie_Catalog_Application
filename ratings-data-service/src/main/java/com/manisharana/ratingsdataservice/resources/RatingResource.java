package com.manisharana.ratingsdataservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingResource {

    @RequestMapping("/{movieId}")
    public Rating getRatingsByMovieId(@PathVariable("movieId") String movieId) {
        HashMap<String, Rating> map = new HashMap<>();
        map.put("movie1290", new Rating("movie1290", "5"));
        map.put("movie1245", new Rating("movie1245", "7"));
        return map.get(movieId);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getRatingByUserId(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(new Rating("movie1290", "5"), new Rating("movie1245", "7"));
        return new UserRating(ratings);
    }
}
