package com.example.MyMovie.service;

import com.example.MyMovie.entity.MovieEntity;
import com.example.MyMovie.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieEntity> getAllMovies() {
        return movieRepository.findAll();
    }
    public MovieEntity createMovie(@RequestBody MovieEntity newMovie){
        return movieRepository.save(newMovie);
    }
    public MovieEntity getMovieByID(@PathVariable Integer id){
        return movieRepository.findById(id).orElseThrow(() ->new RuntimeException("Error Code 25-27 "));

    }
    public List<MovieEntity> getAllMoviesByTitle(String title){
        return movieRepository.findByTitle(title);
    }
    public List<MovieEntity> getAllMoviesByPrice(Double price){
        return movieRepository.findByTickedPrice(price);
    }
    public MovieEntity updateMovie(@PathVariable Integer id, @RequestBody MovieEntity updatedMovie){
        return movieRepository.findById(id)
                .map(exsisting -> {
            exsisting.setTitle(updatedMovie.getTitle());
                    exsisting.setName(updatedMovie.getName());
                    exsisting.setTickedPrice(updatedMovie.getTickedPrice());
           return movieRepository.save(updatedMovie);
        }).orElseThrow(() -> new RuntimeException("Error PLEASE EXIT THE PROGRAM "));
    }
    public String deleteMovie(@PathVariable Integer id){
        if(movieRepository.existsById(id)){
            movieRepository.deleteById(id);
            return "Movie Deleted Happy Birthday";
        }
        return "Error Please Check cod";
    }
}
