package com.stackroute.MovieApp.domain;

import org.springframework.data.annotation.Id;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
@Document
public class Movie {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int movieId;
	private String title;
	private String year;
	private String type;
	private String poster;
	
	public Movie() {
		
	}
	
	public Movie(int movieId,String title, String year, String type, String poster) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.year = year;
		this.type = type;
		this.poster = poster;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	

}
