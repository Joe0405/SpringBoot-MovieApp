package com.stackroute.MovieApp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.repository.MovieRepository;

@Configuration
public class BootStrapDB implements ApplicationListener<ContextRefreshedEvent> {
	//public class BootStrapDB implements CommandLineRunner {
	private MovieRepository movieRepository;
	
	@Autowired
	public BootStrapDB(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}


	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Movie movie1 = new Movie(1,"ABCD","2016","Tragedy","poster.jpg");
		movieRepository.save(movie1);
		
	}


//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}

}
