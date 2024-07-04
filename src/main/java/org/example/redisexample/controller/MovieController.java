package org.example.redisexample.controller;

import org.example.redisexample.model.Movie;
import org.example.redisexample.repository.RedisRepository;
import org.example.redisexample.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/values")
    public @ResponseBody Map<String, String> findAll(){
        return movieService.findAllMovies();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> add(
            @RequestParam String key,
            @RequestParam String value) {

        Movie movie = new Movie(key, value);
        movieService.add(movie);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<String> delete(@RequestParam String key){
        movieService.delete(key);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/movie", method = RequestMethod.GET)
    public ResponseEntity<Movie> findMovie(@RequestParam String id){
        Movie movie =  movieService.findMovie(id);
        System.out.println(movie);
        return movie != null ? new ResponseEntity<>(movie, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
