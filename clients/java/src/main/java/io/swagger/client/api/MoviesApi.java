package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.ApiInvoker;

import io.swagger.client.model.*;

import java.util.*;

import io.swagger.client.model.Movie;

import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

import javax.ws.rs.core.MediaType;

import java.io.File;
import java.util.Map;
import java.util.HashMap;

public class MoviesApi {
  String basePath = "http://localhost:8080/swagger.jersey.demo/webapi";
  ApiInvoker apiInvoker = ApiInvoker.getInstance();

  public ApiInvoker getInvoker() {
    return apiInvoker;
  }

  public void setBasePath(String basePath) {
    this.basePath = basePath;
  }

  public String getBasePath() {
    return basePath;
  }

  
  /**
   * Returns all movies
   * 
   * @return List<Movie>
   */
  public List<Movie> getMovieList () throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/movies".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    
    
    String[] contentTypes = {
      
    };

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      
      if(hasFields)
        postBody = mp;
    }
    else {
      
    }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return (List<Movie>) ApiInvoker.deserialize(response, "array", Movie.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Create a new movie.
   * Cannot reuse an existing id.
   * @param id Movie&#39;s id
   * @param title Title of the movie
   * @param director Who directed the movie
   * @param synopsis Short description about the movie
   * @param yearOfRelease Year it was released
   * @return void
   */
  public void create (Integer id, String title, String director, String synopsis, String yearOfRelease) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/movies/create".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    
    
    String[] contentTypes = {
      
    };

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      
      hasFields = true;
      mp.field("id", ApiInvoker.parameterToString(id), MediaType.MULTIPART_FORM_DATA_TYPE);
      
      hasFields = true;
      mp.field("title", ApiInvoker.parameterToString(title), MediaType.MULTIPART_FORM_DATA_TYPE);
      
      hasFields = true;
      mp.field("director", ApiInvoker.parameterToString(director), MediaType.MULTIPART_FORM_DATA_TYPE);
      
      hasFields = true;
      mp.field("synopsis", ApiInvoker.parameterToString(synopsis), MediaType.MULTIPART_FORM_DATA_TYPE);
      
      hasFields = true;
      mp.field("yearOfRelease", ApiInvoker.parameterToString(yearOfRelease), MediaType.MULTIPART_FORM_DATA_TYPE);
      
      if(hasFields)
        postBody = mp;
    }
    else {
      formParams.put("id", ApiInvoker.parameterToString(id));
      formParams.put("title", ApiInvoker.parameterToString(title));
      formParams.put("director", ApiInvoker.parameterToString(director));
      formParams.put("synopsis", ApiInvoker.parameterToString(synopsis));
      formParams.put("yearOfRelease", ApiInvoker.parameterToString(yearOfRelease));
      
    }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return ;
      }
      else {
        return ;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Returns a single movie for an id
   * You have to supply a valid id.
   * @param id Id of the movie to return
   * @return Movie
   */
  public Movie getMovieById (Integer id) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/movies/{id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    
    
    String[] contentTypes = {
      
    };

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      
      if(hasFields)
        postBody = mp;
    }
    else {
      
    }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return (Movie) ApiInvoker.deserialize(response, "", Movie.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
}
