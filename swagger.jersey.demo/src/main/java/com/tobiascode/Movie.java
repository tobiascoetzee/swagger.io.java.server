package com.tobiascode;

public class Movie {
	private int id;
	private String title;
	private String director;
	private String synopsis;
	private String yearOfRelease;

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
