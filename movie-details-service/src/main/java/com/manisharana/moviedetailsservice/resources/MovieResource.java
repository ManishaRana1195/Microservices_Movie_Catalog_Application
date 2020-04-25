package com.manisharana.moviedetailsservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/movie")
public class MovieResource {


    @RequestMapping("/{movieId}")
    public Movie getMovieDetailsById(@PathVariable("movieId") String movieId) {
        Movie movieA = new Movie("movie1245", "Passengers",
                "A spacecraft traveling to a distant colony planet and transporting thousands of people has a malfunction in its sleep chambers. As a result, two passengers are awakened 90 years early.",
                "Morten Tyldum", 2016);
        Movie movieB = new Movie("movie1290", "Forrest Gump",
                "The presidencies of Kennedy and Johnson, the events of Vietnam, Watergate and other historical events unfold through the perspective of an Alabama man with an IQ of 75, whose only desire is to be reunited with his childhood sweetheart.",
                "Robert Zemeckis", 1994);
        ;

        HashMap<String, Movie> map = new HashMap<>();
        map.put("movie1290", movieB);
        map.put("movie1245", movieA);
        return map.get(movieId);
    }
}
