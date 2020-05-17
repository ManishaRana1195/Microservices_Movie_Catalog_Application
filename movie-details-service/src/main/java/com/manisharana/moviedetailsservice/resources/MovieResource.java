package com.manisharana.moviedetailsservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movie")
public class MovieResource {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{movieId}")
    public Movie getMovieDetailsById(@PathVariable("movieId") String movieId) {

        Movie movie = restTemplate.getForObject(String.format("https://api.themoviedb.org/3/movie/%s?api_key=%s",
                movieId, apiKey), Movie.class);

        return movie;
    }
}
