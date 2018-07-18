package com.stackroute.MovieApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.exceptions.MovieAlreadyExistsException;
import com.stackroute.MovieApp.exceptions.MovieNotFoundException;
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
	public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
	    if(!movieRepository.findAllByTitleIgnoreCase(movie.getTitle()).isEmpty())
	    	throw new MovieAlreadyExistsException("Movie already exists!");
	    else
	    	return movieRepository.save(movie);

	}

	@Override
	public Iterable<Movie> getAllMovies() {

			return movieRepository.findAll();
			

	}

	@Override
	public Movie updateMovie(Movie movie) throws MovieNotFoundException{
		if(movieRepository.existsById(movie.getMovieId()))
			return movieRepository.save(movie);
		else 
			throw new MovieNotFoundException("Movie not found");
	}

	@Override
	public void deleteMovie(int id) throws MovieNotFoundException {
		if(movieRepository.existsById(id))
			movieRepository.deleteById(id);
		else
			throw new MovieNotFoundException("Movie not found");
			
	}

	@Override
	public Optional<Movie> getMovieById(int id) throws MovieNotFoundException {

		
		if(movieRepository.existsById(id))
			return movieRepository.findById(id);
		else
			throw new MovieNotFoundException("Movie not found");
	}

	@Override
	public List<Movie> getMovieByTitle(String title) throws MovieNotFoundException {
		return movieRepository.findAllByTitleIgnoreCase(title);
	}

}
