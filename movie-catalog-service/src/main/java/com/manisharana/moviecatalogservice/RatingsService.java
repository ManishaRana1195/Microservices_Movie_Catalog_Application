package com.manisharana.moviecatalogservice;

import com.manisharana.moviecatalogservice.models.Rating;
import com.manisharana.moviecatalogservice.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class RatingsService {

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "fallbackGetUserRating")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
    /*List of hardcoded user ratings*/
        return restTemplate.getForObject("http://ratings-data-service/ratings/users/" + userId, UserRating.class);
    }

    /*We can make fallback methods more smart and return some cached data instead of hardcoding*/
    public UserRating fallbackGetUserRating(@PathVariable("userId") String userId) {
        UserRating userRating = new UserRating();
        userRating.setRatings(Arrays.asList(new Rating("0", 0)));
        return userRating;
    }
}
