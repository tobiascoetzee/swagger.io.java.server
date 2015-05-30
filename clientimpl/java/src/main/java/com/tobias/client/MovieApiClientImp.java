package com.tobias.client;

import io.swagger.client.ApiException;
import io.swagger.client.ApiInvoker;
import io.swagger.client.api.MoviesApi;
import io.swagger.client.model.Movie;

public class MovieApiClientImp {

	public static void main(String[] args) throws ApiException {
		MoviesApi api = new MoviesApi();

		System.out.println("--- Show All Movies ---");
		
		for(Movie movie: 
			api.getMovieList()){
			System.out.println(movie);
		}
		
		System.out.println("--- Show Movie 4 ---");
		
		System.out.println(api.getMovieById(4));
	}

}
