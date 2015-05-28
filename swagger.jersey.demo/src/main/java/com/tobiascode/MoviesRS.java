package com.tobiascode;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("movies")
public class MoviesRS {
	private static List<Movie> allMovies;

	private List<Movie> getAllMovies() {
		if (allMovies == null) {
			allMovies = createMovieList();
		}

		return allMovies;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMovieList() {
		GenericEntity<List<Movie>> entity = new GenericEntity<List<Movie>>(
				getAllMovies()) {
		};

		return Response.ok(entity).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMovieById(@PathParam("id") int id) {
		Movie foundMovie = findMovieById(id);

		if (foundMovie == null) {
			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.ok(foundMovie).build();
	}

	@POST
	@Path("/create")
	@Produces(MediaType.TEXT_PLAIN)
	public Response create(@FormParam("id") int id,
			@FormParam("title") String title,
			@FormParam("director") String director,
			@FormParam("synopsis") String synopsis,
			@FormParam("yearOfRelease") String yearOfRelease) {
		List<Movie> movies = getAllMovies();

		Movie existingMovie = findMovieById(id);

		if (existingMovie != null) {
			return Response.status(Status.BAD_REQUEST)
					.entity("movie already exists").type(MediaType.TEXT_PLAIN)
					.build();
		}

		movies.add(new Movie(id, title, director, synopsis, yearOfRelease));
		
		return Response.ok("movie added", "text/plain").build();
	}

	private Movie findMovieById(int id) {
		Movie foundMovie = null;

		for (Movie current : getAllMovies()) {
			if (current.getId() == id) {
				foundMovie = current;
				break;
			}
		}

		return foundMovie;
	}

	private List<Movie> createMovieList() {
		List<Movie> movies = new ArrayList<Movie>();

		movies.add(new Movie(
				1,
				"The Godfather",
				"Francis Ford Coppola",
				"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
				"1972"));

		movies.add(new Movie(
				2,
				"The Shawshank Redemption",
				"Frank Darabont",
				"Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency. ",
				"1972"));

		movies.add(new Movie(
				3,
				"Schindler's List ",
				"Steven Spielberg",
				"In Poland during World War II, Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.",
				"1993"));

		movies.add(new Movie(
				4,
				"Raging Bull",
				"Francis Ford Coppola",
				"An emotionally self-destructive boxer's journey through life, as the violence and temper that leads him to the top in the ring, destroys his life outside it.",
				"1980"));

		movies.add(new Movie(
				5,
				"Casablanca",
				"Francis Ford Coppola",
				"Set in unoccupied Africa during the early days of World War II: An American expatriate meets a former lover, with unforeseen complications. ",
				"1942"));

		return movies;
	}
}
