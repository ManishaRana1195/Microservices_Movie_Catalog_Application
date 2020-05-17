package com.manisharana.moviecatalogservice.resources;


import com.manisharana.moviecatalogservice.MovieDetailsService;
import com.manisharana.moviecatalogservice.RatingsService;
import com.manisharana.moviecatalogservice.models.CatalogItem;
import com.manisharana.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MovieDetailsService movieDetailsService;

    @Autowired
    private RatingsService ratingsService;


    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalogByUserId(@PathVariable("userId") String userId) {
        UserRating userRating = ratingsService.getUserRating(userId);

        return userRating.getRatings().stream()
                .map(rating -> movieDetailsService.getCatalogItem(rating))
                .collect(Collectors.toList());
    }


}
