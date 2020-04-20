package com.manisharana.moviecatalogservice.resources;


import com.manisharana.moviecatalogservice.models.CatalogItem;
import com.manisharana.moviecatalogservice.models.Movie;
import com.manisharana.moviecatalogservice.models.Rating;
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

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalogByUserId(@PathVariable("userId") String userId) {
        RestTemplate rest = new RestTemplate();

        /*List of hardcoded user ratings*/
        List<Rating> ratings = Arrays.asList(
                new Rating("movie1234", 4),
                new Rating("movie178", 5)
        );

        return ratings.stream().map(rating -> {
                    Movie movie = rest.getForObject("http://localhost:8081/movie/" + rating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getName(), movie.getDescription(), rating.getMovieRating());
                }
        ).collect(Collectors.toList());
    }
}
