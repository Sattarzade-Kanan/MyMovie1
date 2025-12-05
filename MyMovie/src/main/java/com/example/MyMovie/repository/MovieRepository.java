package com.example.MyMovie.repository;

import com.example.MyMovie.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity , Integer> {
    List<MovieEntity> findByTitle(String title);
    List<MovieEntity> findByTickedPrice(Double price);
}
