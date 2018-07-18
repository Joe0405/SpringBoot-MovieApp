package com.stackroute.MovieApp.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.exceptions.MovieAlreadyExistsException;
import com.stackroute.MovieApp.exceptions.MovieNotFoundException;
import com.stackroute.MovieApp.service.MovieService;

@RestController
@RequestMapping("/api/v1")
public class MovieController {
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private MovieService movieService;
	@Autowired
	public MovieController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
		try {
			movieService.saveMovie(movie);
			return new ResponseEntity<Movie>(movie,HttpStatus.CREATED);
		} catch (MovieAlreadyExistsException e) {
			
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST); 		
			}
		
	}
	
	@GetMapping("/display")
	public ResponseEntity<?> displayAll() {
	    logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
		
		return new ResponseEntity<Iterable<Movie>>(movieService.getAllMovies(),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateMovie(@PathVariable("id") int id,@RequestBody Movie movie) {
		try {
			movie.setMovieId(id);
			return new ResponseEntity<Movie>(movieService.updateMovie(movie),HttpStatus.OK);
		} catch (MovieNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteMovie(@PathVariable("id") int id) {
		try {
			movieService.deleteMovie(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (MovieNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/display/{id}")
	public ResponseEntity<?> displayById(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<Optional<Movie>>(movieService.getMovieById(id),HttpStatus.OK);
		} catch (MovieNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/displaybytitle/{title}")
	public ResponseEntity<?> displayByTitle(@PathVariable("title") String title) {
		try {
			return new ResponseEntity<List<Movie>>(movieService.getMovieByTitle(title),HttpStatus.OK);
		} catch (MovieNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	

}
