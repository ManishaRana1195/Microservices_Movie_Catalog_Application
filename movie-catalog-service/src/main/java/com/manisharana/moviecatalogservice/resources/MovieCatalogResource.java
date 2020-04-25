package com.manisharana.moviecatalogservice.resources;


import com.manisharana.moviecatalogservice.models.CatalogItem;
import com.manisharana.moviecatalogservice.models.Movie;
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


    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalogByUserId(@PathVariable("userId") String userId) {

        /*List of hardcoded user ratings*/
        UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratings/users/" + userId, UserRating.class);

        return userRating.getRatings().stream().map(rating -> {
                    Movie movie = restTemplate.getForObject("http://movie-details-service/movie/" + rating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getName(), movie.getDescription(), rating.getMovieRating());
                }
        ).collect(Collectors.toList());
    }
}
