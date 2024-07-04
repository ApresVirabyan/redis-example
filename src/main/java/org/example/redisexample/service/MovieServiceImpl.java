package org.example.redisexample.service;

import org.example.redisexample.model.Movie;
import org.example.redisexample.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private RedisRepository redisRepository;

    @Override
    public Map<String, String> findAllMovies() {
        Map<Object, Object> aa = redisRepository.findAllMovies();
        Map<String, String> map = new HashMap<>();

        for(Map.Entry<Object, Object> entry: aa.entrySet()){
            String key = (String) entry.getKey();
            map.put(key, aa.get(key).toString());
        }
        return map;
    }

    @Override
    public void add(Movie movie) {
        redisRepository.add(movie);
    }

    @Override
    public void delete(String id) {
         redisRepository.delete(id);
    }

    @Override
    public Movie findMovie(String id) {
        return redisRepository.findMovie(id);
    }
}
