package org.example.redisexample.service;

import org.example.redisexample.model.Movie;
import org.example.redisexample.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


public interface MovieService {

    Map<String, String> findAllMovies();

    void add(Movie movie);

    void delete(String id);

    Movie findMovie(String id);

}
