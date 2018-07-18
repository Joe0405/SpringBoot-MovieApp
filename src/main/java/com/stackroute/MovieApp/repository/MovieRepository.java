package com.stackroute.MovieApp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.stackroute.MovieApp.domain.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, Integer> {
	public List<Movie> findAllByTitleIgnoreCase(String title);

}
