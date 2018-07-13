package com.stackroute.MovieApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.service.MovieService;

@RestController
@RequestMapping("/api/v1")
public class MovieController {
	
	private MovieService movieService;
	@Autowired
	public MovieController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
		movieService.saveMovie(movie);
		return new ResponseEntity<Movie>(movie,HttpStatus.CREATED);
	}
	
	@GetMapping("/display")
	public ResponseEntity<?> displayAll() {
		
		return new ResponseEntity<Iterable<Movie>>(movieService.getAllMovies(),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteMovie(@PathVariable("id") int id) {
		movieService.deleteMovie(id);
		return new ResponseEntity<String>(HttpStatus.OK);
		
	}
	

}
