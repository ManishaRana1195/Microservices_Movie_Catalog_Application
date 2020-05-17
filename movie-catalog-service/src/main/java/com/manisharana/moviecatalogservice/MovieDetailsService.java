package com.manisharana.moviecatalogservice;

import com.manisharana.moviecatalogservice.models.CatalogItem;
import com.manisharana.moviecatalogservice.models.Movie;
import com.manisharana.moviecatalogservice.models.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieDetailsService {

    @Autowired
    private RestTemplate restTemplate;


    public CatalogItem fallbackGetCatalogItem(Rating rating) {
        return new CatalogItem(new Movie("0", "No movies available", "", ""), rating.getMovieRating());
    }


    @HystrixCommand(fallbackMethod = "fallbackGetCatalogItem")
    public CatalogItem getCatalogItem(Rating rating) {
        Movie movie = restTemplate.getForObject("http://movie-details-service/movie/" + rating.getMovieId(), Movie.class);
        return new CatalogItem(movie, rating.getMovieRating());
    }

}
