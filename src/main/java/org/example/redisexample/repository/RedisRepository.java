package org.example.redisexample.repository;

import org.example.redisexample.model.Movie;

import java.util.Map;

public interface RedisRepository {

    Map<Object, Object> findAllMovies();

    void add(Movie movie);

    void delete(String id);

    Movie findMovie(String id);
}
