package com.example.MyMovie.controller;

import com.example.MyMovie.service.MovieService;
import com.example.MyMovie.entity.MovieEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping("/all")
    public List<MovieEntity> getAllMovies() {
        return movieService.getAllMovies();
    }
    @PostMapping("/add")
    public MovieEntity addMovie(@RequestBody MovieEntity newMovie){
        return movieService.createMovie(newMovie);
    }


       @PutMapping("/update/{id}")
    public MovieEntity updateMovie(@PathVariable Integer id , @RequestBody MovieEntity updatedMovie){
        return movieService.updateMovie(id, updatedMovie);
       }

       @DeleteMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Integer id){
     return   movieService.deleteMovie(id);
       }
       @GetMapping("/title/{title}")
    public List<MovieEntity> getALLMoviesByTitle(String title){
        return movieService.getAllMoviesByTitle(title);
       }
    @GetMapping("/price/{price}")
    public List<MovieEntity> getALLMoviesByPrice(String price){
        return movieService.getAllMoviesByPrice(price);
    }
}
