package com.manisharana.moviecatalogservice;

import com.manisharana.moviecatalogservice.models.CatalogItem;
import com.manisharana.moviecatalogservice.models.Movie;
import com.manisharana.moviecatalogservice.models.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieDetailsService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackGetCatalogItem", threadPoolKey = "movieDetailServicePool", threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "20"),
            @HystrixProperty(name = "maxQueueSize", value = "10")
    })
    public CatalogItem getCatalogItem(Rating rating) {
        Movie movie = restTemplate.getForObject("http://movie-details-service/movie/" + rating.getMovieId(), Movie.class);
        return new CatalogItem(movie, rating.getMovieRating());
    }

    public CatalogItem fallbackGetCatalogItem(Rating rating) {
        return new CatalogItem(new Movie("0", "No movies available", "", ""), rating.getMovieRating());
    }


}
