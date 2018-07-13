package com.stackroute.MovieApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.repository.MovieRepository;
@Service
public class MovieServiceImpl implements MovieService{
	
	private MovieRepository movieRepository;
	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}

	@Override
	public Movie saveMovie(Movie movie) {
	
		return movieRepository.save(movie);

	}

	@Override
	public Iterable<Movie> getAllMovies() {
		return movieRepository.findAll();

	}

	@Override
	public Movie updateMovie(Movie movie) {

		return null;
	}

	@Override
	public void deleteMovie(int id) {

		movieRepository.deleteById(id);
	}

	@Override
	public Optional<Movie> getMovieById(int id) {

		return movieRepository.findById(id);
	}

}
