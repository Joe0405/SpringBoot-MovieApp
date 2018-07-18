package com.stackroute.MovieApp.service;
import java.util.List;
import java.util.Optional;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.exceptions.MovieAlreadyExistsException;
import com.stackroute.MovieApp.exceptions.MovieNotFoundException;


public interface MovieService {
	public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException;
	public Iterable<Movie> getAllMovies();
	public Optional<Movie> getMovieById(int id) throws MovieNotFoundException;
	public Movie updateMovie(Movie movie) throws MovieNotFoundException;
	public List<Movie> getMovieByTitle(String title) throws MovieNotFoundException;
	public void deleteMovie(int id) throws MovieNotFoundException;

}
