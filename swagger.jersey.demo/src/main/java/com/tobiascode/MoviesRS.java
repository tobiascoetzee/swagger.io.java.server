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

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("movies")
@Api(value = "/movies")
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
	@ApiOperation(value = "Returns all movies", response = Movie.class, responseContainer = "List")
	public Response getMovieList() {
		GenericEntity<List<Movie>> entity = new GenericEntity<List<Movie>>(
				getAllMovies()) {
		};

		return Response.ok(entity).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Returns a single movie for an id", notes ="You have to supply a valid id.", response = Movie.class)
	@ApiResponses({
		@ApiResponse(code = 404, message = "No movie with the given id exists.")
	})
	public Response getMovieById(@ApiParam(value = "Id of the movie to return")@PathParam("id") int id) {
		Movie foundMovie = findMovieById(id);

		if (foundMovie == null) {
			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.ok(foundMovie).build();
	}

	@POST
	@Path("/create")
	@Produces(MediaType.TEXT_PLAIN)
	@ApiOperation(value="Create a new movie.", notes="Cannot reuse an existing id.")
	@ApiResponses({
		@ApiResponse(code = 400, message = "Cannot add a new movie with an existing id.")
	})	
	public Response create(@ApiParam(value = "Movie's id")@FormParam("id") int id,
			@ApiParam(value = "Title of the movie")@FormParam("title") String title,
			@ApiParam(value = "Who directed the movie")@FormParam("director") String director,
			@ApiParam(value = "Short description about the movie")@FormParam("synopsis") String synopsis,
			@ApiParam(value = "Year it was released")@FormParam("yearOfRelease") String yearOfRelease) {
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
