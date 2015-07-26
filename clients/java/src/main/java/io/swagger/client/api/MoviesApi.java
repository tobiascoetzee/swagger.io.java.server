package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.ApiClient;
import io.swagger.client.Configuration;

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
  private ApiClient apiClient;

  public MoviesApi() {
    this(Configuration.getDefaultApiClient());
  }

  public MoviesApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
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

    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      
      if(hasFields)
        postBody = mp;
    }
    else {
      
    }

    try {
      String[] authNames = new String[] {  };
      String response = apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames);
      if(response != null){
        return (List<Movie>) apiClient.deserialize(response, "array", Movie.class);
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

    

    

    final String[] accepts = {
      "text/plain"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      
      if (id != null) {
        hasFields = true;
        mp.field("id", apiClient.parameterToString(id), MediaType.MULTIPART_FORM_DATA_TYPE);
      }
      
      if (title != null) {
        hasFields = true;
        mp.field("title", apiClient.parameterToString(title), MediaType.MULTIPART_FORM_DATA_TYPE);
      }
      
      if (director != null) {
        hasFields = true;
        mp.field("director", apiClient.parameterToString(director), MediaType.MULTIPART_FORM_DATA_TYPE);
      }
      
      if (synopsis != null) {
        hasFields = true;
        mp.field("synopsis", apiClient.parameterToString(synopsis), MediaType.MULTIPART_FORM_DATA_TYPE);
      }
      
      if (yearOfRelease != null) {
        hasFields = true;
        mp.field("yearOfRelease", apiClient.parameterToString(yearOfRelease), MediaType.MULTIPART_FORM_DATA_TYPE);
      }
      
      if(hasFields)
        postBody = mp;
    }
    else {
      if (id != null)
        formParams.put("id", apiClient.parameterToString(id));
      if (title != null)
        formParams.put("title", apiClient.parameterToString(title));
      if (director != null)
        formParams.put("director", apiClient.parameterToString(director));
      if (synopsis != null)
        formParams.put("synopsis", apiClient.parameterToString(synopsis));
      if (yearOfRelease != null)
        formParams.put("yearOfRelease", apiClient.parameterToString(yearOfRelease));
      
    }

    try {
      String[] authNames = new String[] {  };
      String response = apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, authNames);
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
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling getMovieById");
    }
    

    // create path and map variables
    String path = "/movies/{id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      
      if(hasFields)
        postBody = mp;
    }
    else {
      
    }

    try {
      String[] authNames = new String[] {  };
      String response = apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames);
      if(response != null){
        return (Movie) apiClient.deserialize(response, "", Movie.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
}
