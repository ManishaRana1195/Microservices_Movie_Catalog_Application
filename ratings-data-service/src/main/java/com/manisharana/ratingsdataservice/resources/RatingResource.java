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
        map.put("550", new Rating("550", "5"));
        map.put("770", new Rating("770", "7"));
        return map.get(movieId);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getRatingByUserId(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(new Rating("550", "5"), new Rating("770", "7"));
        return new UserRating(ratings);
    }
}
