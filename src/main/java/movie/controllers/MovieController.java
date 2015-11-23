package movie.controllers;

import movie.models.Movie;
import movie.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MovieController {
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping("/movie")
    public List<Movie> movie(@RequestParam(value="search", defaultValue="batman") String search) {
        return movieRepository.findByOriginalTitle(search);
    }

}
