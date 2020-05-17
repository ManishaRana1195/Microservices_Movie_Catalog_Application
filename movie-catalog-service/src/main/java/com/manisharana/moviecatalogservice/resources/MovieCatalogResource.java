package com.manisharana.moviecatalogservice.resources;


import com.manisharana.moviecatalogservice.models.CatalogItem;
import com.manisharana.moviecatalogservice.models.Movie;
import com.manisharana.moviecatalogservice.models.Rating;
import com.manisharana.moviecatalogservice.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalogByUserId(@PathVariable("userId") String userId) {
        UserRating userRating = getUserRating(userId);

        return userRating.getRatings().stream()
                .map(this::getCatalogItem)
                .collect(Collectors.toList());
    }

    @HystrixCommand(fallbackMethod = "fallbackGetCatalogItem")
    private CatalogItem getCatalogItem(Rating rating) {
        Movie movie = restTemplate.getForObject("http://movie-details-service/movie/" + rating.getMovieId(), Movie.class);
        return new CatalogItem(movie, rating.getMovieRating());
    }

    @HystrixCommand(fallbackMethod = "fallbackGetUserRating")
    private UserRating getUserRating(@PathVariable("userId") String userId) {
    /*List of hardcoded user ratings*/
        return restTemplate.getForObject("http://ratings-data-service/ratings/users/" + userId, UserRating.class);
    }

    private CatalogItem fallbackGetCatalogItem(Rating rating) {
        return new CatalogItem(new Movie("0", "No movies available", "", ""), rating.getMovieRating());
    }

    /*We can make fallback methods more smart and return some cached data instead of hardcoding*/
    private UserRating fallbackGetUserRating(@PathVariable("userId") String userId) {
        UserRating userRating = new UserRating();
        userRating.setRatings(Arrays.asList(new Rating("0", 0)));
        return userRating;
    }
}
