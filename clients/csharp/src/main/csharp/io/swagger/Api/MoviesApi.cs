using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using RestSharp;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace IO.Swagger.Api {
  

  public interface IMoviesApi {
    
    /// <summary>
    /// Returns all movies 
    /// </summary>
    
    /// <returns>List<Movie></returns>
    List<Movie> GetMovieList ();

    /// <summary>
    /// Returns all movies 
    /// </summary>
    
    /// <returns>List<Movie></returns>
    Task<List<Movie>> GetMovieListAsync ();
    
    /// <summary>
    /// Create a new movie. Cannot reuse an existing id.
    /// </summary>
    /// <param name="Id">Movie&#39;s id</param>/// <param name="Title">Title of the movie</param>/// <param name="Director">Who directed the movie</param>/// <param name="Synopsis">Short description about the movie</param>/// <param name="YearOfRelease">Year it was released</param>
    /// <returns></returns>
    void Create (int? Id, string Title, string Director, string Synopsis, string YearOfRelease);

    /// <summary>
    /// Create a new movie. Cannot reuse an existing id.
    /// </summary>
    /// <param name="Id">Movie&#39;s id</param>/// <param name="Title">Title of the movie</param>/// <param name="Director">Who directed the movie</param>/// <param name="Synopsis">Short description about the movie</param>/// <param name="YearOfRelease">Year it was released</param>
    /// <returns></returns>
    Task CreateAsync (int? Id, string Title, string Director, string Synopsis, string YearOfRelease);
    
    /// <summary>
    /// Returns a single movie for an id You have to supply a valid id.
    /// </summary>
    /// <param name="Id">Id of the movie to return</param>
    /// <returns>Movie</returns>
    Movie GetMovieById (int? Id);

    /// <summary>
    /// Returns a single movie for an id You have to supply a valid id.
    /// </summary>
    /// <param name="Id">Id of the movie to return</param>
    /// <returns>Movie</returns>
    Task<Movie> GetMovieByIdAsync (int? Id);
    
  }

  /// <summary>
  /// Represents a collection of functions to interact with the API endpoints
  /// </summary>
  public class MoviesApi : IMoviesApi {

    /// <summary>
    /// Initializes a new instance of the <see cref="MoviesApi"/> class.
    /// </summary>
    /// <param name="apiClient"> an instance of ApiClient (optional)
    /// <returns></returns>
    public MoviesApi(ApiClient apiClient = null) {
      if (apiClient == null) { // use the default one in Configuration
        this.apiClient = Configuration.apiClient; 
      } else {
        this.apiClient = apiClient;
      }
    }

    /// <summary>
    /// Initializes a new instance of the <see cref="MoviesApi"/> class.
    /// </summary>
    /// <returns></returns>
    public MoviesApi(String basePath)
    {
      this.apiClient = new ApiClient(basePath);
    }

    /// <summary>
    /// Sets the base path of the API client.
    /// </summary>
    /// <value>The base path</value>
    public void SetBasePath(String basePath) {
      this.apiClient.basePath = basePath;
    }

    /// <summary>
    /// Gets the base path of the API client.
    /// </summary>
    /// <value>The base path</value>
    public String GetBasePath(String basePath) {
      return this.apiClient.basePath;
    }

    /// <summary>
    /// Gets or sets the API client.
    /// </summary>
    /// <value>The API client</value>
    public ApiClient apiClient {get; set;}


    
    /// <summary>
    /// Returns all movies 
    /// </summary>
    
    /// <returns>List<Movie></returns>
    public List<Movie> GetMovieList () {

      

      var path = "/movies";
      path = path.Replace("{format}", "json");
      

      var queryParams = new Dictionary<String, String>();
      var headerParams = new Dictionary<String, String>();
      var formParams = new Dictionary<String, String>();
      var fileParams = new Dictionary<String, String>();
      String postBody = null;

      
      
      
      

      // authentication setting, if any
      String[] authSettings = new String[] {  };

      // make the HTTP request
      IRestResponse response = (IRestResponse) apiClient.CallApi(path, Method.GET, queryParams, postBody, headerParams, formParams, fileParams, authSettings);

      if (((int)response.StatusCode) >= 400) {
        throw new ApiException ((int)response.StatusCode, "Error calling GetMovieList: " + response.Content, response.Content);
      }
      return (List<Movie>) apiClient.Deserialize(response.Content, typeof(List<Movie>));
    }
	
	 /// <summary>
    /// Returns all movies 
    /// </summary>
    
    /// <returns>List<Movie></returns>
    public async Task<List<Movie>> GetMovieListAsync () {

      

      var path = "/movies";
      path = path.Replace("{format}", "json");
      

      var queryParams = new Dictionary<String, String>();
      var headerParams = new Dictionary<String, String>();
      var formParams = new Dictionary<String, String>();
      var fileParams = new Dictionary<String, String>();
      String postBody = null;

      
      
      
      

      // authentication setting, if any
      String[] authSettings = new String[] {  };

      // make the HTTP request
      IRestResponse response = (IRestResponse) await apiClient.CallApiAsync(path, Method.GET, queryParams, postBody, headerParams, formParams, fileParams, authSettings);
      if (((int)response.StatusCode) >= 400) {
        throw new ApiException ((int)response.StatusCode, "Error calling GetMovieList: " + response.Content, response.Content);
      }
      return (List<Movie>) apiClient.Deserialize(response.Content, typeof(List<Movie>));
    }
    
    /// <summary>
    /// Create a new movie. Cannot reuse an existing id.
    /// </summary>
    /// <param name="Id">Movie&#39;s id</param>/// <param name="Title">Title of the movie</param>/// <param name="Director">Who directed the movie</param>/// <param name="Synopsis">Short description about the movie</param>/// <param name="YearOfRelease">Year it was released</param>
    /// <returns></returns>
    public void Create (int? Id, string Title, string Director, string Synopsis, string YearOfRelease) {

      

      var path = "/movies/create";
      path = path.Replace("{format}", "json");
      

      var queryParams = new Dictionary<String, String>();
      var headerParams = new Dictionary<String, String>();
      var formParams = new Dictionary<String, String>();
      var fileParams = new Dictionary<String, String>();
      String postBody = null;

      
      
      if (Id != null) formParams.Add("id", apiClient.ParameterToString(Id)); // form parameter
      if (Title != null) formParams.Add("title", apiClient.ParameterToString(Title)); // form parameter
      if (Director != null) formParams.Add("director", apiClient.ParameterToString(Director)); // form parameter
      if (Synopsis != null) formParams.Add("synopsis", apiClient.ParameterToString(Synopsis)); // form parameter
      if (YearOfRelease != null) formParams.Add("yearOfRelease", apiClient.ParameterToString(YearOfRelease)); // form parameter
      
      

      // authentication setting, if any
      String[] authSettings = new String[] {  };

      // make the HTTP request
      IRestResponse response = (IRestResponse) apiClient.CallApi(path, Method.POST, queryParams, postBody, headerParams, formParams, fileParams, authSettings);

      if (((int)response.StatusCode) >= 400) {
        throw new ApiException ((int)response.StatusCode, "Error calling Create: " + response.Content, response.Content);
      }
      
      return;
    }
	
	 /// <summary>
    /// Create a new movie. Cannot reuse an existing id.
    /// </summary>
    /// <param name="Id">Movie&#39;s id</param>/// <param name="Title">Title of the movie</param>/// <param name="Director">Who directed the movie</param>/// <param name="Synopsis">Short description about the movie</param>/// <param name="YearOfRelease">Year it was released</param>
    /// <returns></returns>
    public async Task CreateAsync (int? Id, string Title, string Director, string Synopsis, string YearOfRelease) {

      

      var path = "/movies/create";
      path = path.Replace("{format}", "json");
      

      var queryParams = new Dictionary<String, String>();
      var headerParams = new Dictionary<String, String>();
      var formParams = new Dictionary<String, String>();
      var fileParams = new Dictionary<String, String>();
      String postBody = null;

      
      
      if (Id != null) formParams.Add("id", apiClient.ParameterToString(Id)); // form parameter
      if (Title != null) formParams.Add("title", apiClient.ParameterToString(Title)); // form parameter
      if (Director != null) formParams.Add("director", apiClient.ParameterToString(Director)); // form parameter
      if (Synopsis != null) formParams.Add("synopsis", apiClient.ParameterToString(Synopsis)); // form parameter
      if (YearOfRelease != null) formParams.Add("yearOfRelease", apiClient.ParameterToString(YearOfRelease)); // form parameter
      
      

      // authentication setting, if any
      String[] authSettings = new String[] {  };

      // make the HTTP request
      IRestResponse response = (IRestResponse) await apiClient.CallApiAsync(path, Method.POST, queryParams, postBody, headerParams, formParams, fileParams, authSettings);
      if (((int)response.StatusCode) >= 400) {
        throw new ApiException ((int)response.StatusCode, "Error calling Create: " + response.Content, response.Content);
      }
      
      return;
    }
    
    /// <summary>
    /// Returns a single movie for an id You have to supply a valid id.
    /// </summary>
    /// <param name="Id">Id of the movie to return</param>
    /// <returns>Movie</returns>
    public Movie GetMovieById (int? Id) {

      
      // verify the required parameter 'Id' is set
      if (Id == null) throw new ApiException(400, "Missing required parameter 'Id' when calling GetMovieById");
      

      var path = "/movies/{id}";
      path = path.Replace("{format}", "json");
      path = path.Replace("{" + "id" + "}", apiClient.ParameterToString(Id));
      

      var queryParams = new Dictionary<String, String>();
      var headerParams = new Dictionary<String, String>();
      var formParams = new Dictionary<String, String>();
      var fileParams = new Dictionary<String, String>();
      String postBody = null;

      
      
      
      

      // authentication setting, if any
      String[] authSettings = new String[] {  };

      // make the HTTP request
      IRestResponse response = (IRestResponse) apiClient.CallApi(path, Method.GET, queryParams, postBody, headerParams, formParams, fileParams, authSettings);

      if (((int)response.StatusCode) >= 400) {
        throw new ApiException ((int)response.StatusCode, "Error calling GetMovieById: " + response.Content, response.Content);
      }
      return (Movie) apiClient.Deserialize(response.Content, typeof(Movie));
    }
	
	 /// <summary>
    /// Returns a single movie for an id You have to supply a valid id.
    /// </summary>
    /// <param name="Id">Id of the movie to return</param>
    /// <returns>Movie</returns>
    public async Task<Movie> GetMovieByIdAsync (int? Id) {

      
          // verify the required parameter 'Id' is set
          if (Id == null) throw new ApiException(400, "Missing required parameter 'Id' when calling GetMovieById");
      

      var path = "/movies/{id}";
      path = path.Replace("{format}", "json");
      path = path.Replace("{" + "id" + "}", apiClient.ParameterToString(Id));
      

      var queryParams = new Dictionary<String, String>();
      var headerParams = new Dictionary<String, String>();
      var formParams = new Dictionary<String, String>();
      var fileParams = new Dictionary<String, String>();
      String postBody = null;

      
      
      
      

      // authentication setting, if any
      String[] authSettings = new String[] {  };

      // make the HTTP request
      IRestResponse response = (IRestResponse) await apiClient.CallApiAsync(path, Method.GET, queryParams, postBody, headerParams, formParams, fileParams, authSettings);
      if (((int)response.StatusCode) >= 400) {
        throw new ApiException ((int)response.StatusCode, "Error calling GetMovieById: " + response.Content, response.Content);
      }
      return (Movie) apiClient.Deserialize(response.Content, typeof(Movie));
    }
    
  }  
  
}
