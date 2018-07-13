package com.stackroute.MovieApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.stackroute.MovieApp.domain.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
