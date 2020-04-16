package com.manisharana.moviedetailsservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieResource {

    @RequestMapping("/{movieId}")
    public Movie getMovieDetailsById(@PathVariable("movieId") String movieId) {
        return new Movie("20", "1917", "Starring benedict Cumberbatch");
    }
}
