package com.tobiascode;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel( value = "Movie", description = "All the details about a movie" )
public class Movie {
	@ApiModelProperty( value = "Movie's id")private int id;
	@ApiModelProperty( value = "Title of the movie")private String title;
	@ApiModelProperty( value = "Who directed the movie")private String director;
	@ApiModelProperty( value = "Short description about the movie")private String synopsis;
	@ApiModelProperty( value = "Year it was released")private String yearOfRelease;

	public Movie() {
	}

	public Movie(int id, String title, String director, String synopsis,
			String yearOfRelease) {
		setId(id);
		setTitle(title);
		setDirector(director);
		setSynopsis(synopsis);
		setYearOfRelease(yearOfRelease);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(String yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}
}
