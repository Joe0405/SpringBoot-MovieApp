package com.stackroute.MovieApp.service;
import java.util.List;
import java.util.Optional;

import com.stackroute.MovieApp.domain.Movie;


public interface MovieService {
	public Movie saveMovie(Movie movie);
	public Iterable<Movie> getAllMovies();
	public Optional<Movie> getMovieById(int id);
	public Movie updateMovie(Movie movie);
	public void deleteMovie(int id);

}
