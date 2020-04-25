package com.manisharana.moviedetailsservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieResource {

    @RequestMapping("/{movieId}")
    public Movie getMovieDetailsById(@PathVariable("movieId") String movieId) {
        return new Movie("movie12451", " Passengers",
                "A spacecraft traveling to a distant colony planet and transporting thousands of people has a malfunction in its sleep chambers. As a result, two passengers are awakened 90 years early.",
                "Morten Tyldum", 2016);
    }
}
