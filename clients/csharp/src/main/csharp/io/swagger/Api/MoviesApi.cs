using System;
using System.Collections.Generic;
using io.swagger.client;
using io.swagger.Model;

namespace io.swagger.Api {
  
  public class MoviesApi {
    string basePath;
    private readonly ApiInvoker apiInvoker = ApiInvoker.GetInstance();

    public MoviesApi(String basePath = "http://localhost:8080/swagger.jersey.demo/webapi")
    {
      this.basePath = basePath;
    }

    public ApiInvoker getInvoker() {
      return apiInvoker;
    }

    // Sets the endpoint base url for the services being accessed
    public void setBasePath(string basePath) {
      this.basePath = basePath;
    }

    // Gets the endpoint base url for the services being accessed
    public String getBasePath() {
      return basePath;
    }

    

    /// <summary>
    /// Returns all movies 
    /// </summary>
    
    /// <returns></returns>
    public List<Movie>  getMovieList () {
      // create path and map variables
      var path = "/movies".Replace("{format}","json");

      // query params
      var queryParams = new Dictionary<String, String>();
      var headerParams = new Dictionary<String, String>();
      var formParams = new Dictionary<String, object>();

      

      

      

      

      try {
        if (typeof(List<Movie>) == typeof(byte[])) {
          
          var response = apiInvoker.invokeBinaryAPI(basePath, path, "GET", queryParams, null, headerParams, formParams);
          return ((object)response) as List<Movie>;
          
          
        } else {
          
          var response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, formParams);
          if (response != null){
             return (List<Movie>) ApiInvoker.deserialize(response, typeof(List<Movie>));
          }
          else {
            return null;
          }
          
          
        }
      } catch (ApiException ex) {
        if(ex.ErrorCode == 404) {
          return null;
        }
        else {
          throw ex;
        }
      }
    }
    

    /// <summary>
    /// Create a new movie. Cannot reuse an existing id.
    /// </summary>
    /// <param name="Id">Movie&#39;s id</param>
     /// <param name="Title">Title of the movie</param>
     /// <param name="Director">Who directed the movie</param>
     /// <param name="Synopsis">Short description about the movie</param>
     /// <param name="YearOfRelease">Year it was released</param>
    
    /// <returns></returns>
    public void  create (int? Id, string Title, string Director, string Synopsis, string YearOfRelease) {
      // create path and map variables
      var path = "/movies/create".Replace("{format}","json");

      // query params
      var queryParams = new Dictionary<String, String>();
      var headerParams = new Dictionary<String, String>();
      var formParams = new Dictionary<String, object>();

      

      

      

      if (Id != null){
        if(Id is byte[]) {
          formParams.Add("id", Id);
        } else {
          string paramStr = (Id is DateTime) ? ((DateTime)(object)Id).ToString("u") : Convert.ToString(Id);
          formParams.Add("id", paramStr);
        }
      }
      if (Title != null){
        if(Title is byte[]) {
          formParams.Add("title", Title);
        } else {
          string paramStr = (Title is DateTime) ? ((DateTime)(object)Title).ToString("u") : Convert.ToString(Title);
          formParams.Add("title", paramStr);
        }
      }
      if (Director != null){
        if(Director is byte[]) {
          formParams.Add("director", Director);
        } else {
          string paramStr = (Director is DateTime) ? ((DateTime)(object)Director).ToString("u") : Convert.ToString(Director);
          formParams.Add("director", paramStr);
        }
      }
      if (Synopsis != null){
        if(Synopsis is byte[]) {
          formParams.Add("synopsis", Synopsis);
        } else {
          string paramStr = (Synopsis is DateTime) ? ((DateTime)(object)Synopsis).ToString("u") : Convert.ToString(Synopsis);
          formParams.Add("synopsis", paramStr);
        }
      }
      if (YearOfRelease != null){
        if(YearOfRelease is byte[]) {
          formParams.Add("yearOfRelease", YearOfRelease);
        } else {
          string paramStr = (YearOfRelease is DateTime) ? ((DateTime)(object)YearOfRelease).ToString("u") : Convert.ToString(YearOfRelease);
          formParams.Add("yearOfRelease", paramStr);
        }
      }
      

      try {
        if (typeof(void) == typeof(byte[])) {
          
          
          apiInvoker.invokeBinaryAPI(basePath, path, "GET", queryParams, null, headerParams, formParams);
          return;
          
        } else {
          
          
          apiInvoker.invokeAPI(basePath, path, "POST", queryParams, null, headerParams, formParams);
          return;
          
        }
      } catch (ApiException ex) {
        if(ex.ErrorCode == 404) {
          return ;
        }
        else {
          throw ex;
        }
      }
    }
    

    /// <summary>
    /// Returns a single movie for an id You have to supply a valid id.
    /// </summary>
    /// <param name="Id">Id of the movie to return</param>
    
    /// <returns></returns>
    public Movie  getMovieById (int? Id) {
      // create path and map variables
      var path = "/movies/{id}".Replace("{format}","json").Replace("{" + "id" + "}", apiInvoker.escapeString(Id.ToString()));

      // query params
      var queryParams = new Dictionary<String, String>();
      var headerParams = new Dictionary<String, String>();
      var formParams = new Dictionary<String, object>();

      

      

      

      

      try {
        if (typeof(Movie) == typeof(byte[])) {
          
          var response = apiInvoker.invokeBinaryAPI(basePath, path, "GET", queryParams, null, headerParams, formParams);
          return ((object)response) as Movie;
          
          
        } else {
          
          var response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, formParams);
          if (response != null){
             return (Movie) ApiInvoker.deserialize(response, typeof(Movie));
          }
          else {
            return null;
          }
          
          
        }
      } catch (ApiException ex) {
        if(ex.ErrorCode == 404) {
          return null;
        }
        else {
          throw ex;
        }
      }
    }
    
  }
  
}
