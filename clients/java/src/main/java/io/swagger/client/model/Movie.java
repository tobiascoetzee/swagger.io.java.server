package io.swagger.client.model;


import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * All the details about a movie
 **/
@ApiModel(description = "All the details about a movie")
public class Movie  {
  
  private Integer id = null;
  private String title = null;
  private String director = null;
  private String synopsis = null;
  private String yearOfRelease = null;

  
  /**
   * Movie's id
   **/
  @ApiModelProperty(value = "Movie's id")
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  
  /**
   * Title of the movie
   **/
  @ApiModelProperty(value = "Title of the movie")
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  
  /**
   * Who directed the movie
   **/
  @ApiModelProperty(value = "Who directed the movie")
  @JsonProperty("director")
  public String getDirector() {
    return director;
  }
  public void setDirector(String director) {
    this.director = director;
  }

  
  /**
   * Short description about the movie
   **/
  @ApiModelProperty(value = "Short description about the movie")
  @JsonProperty("synopsis")
  public String getSynopsis() {
    return synopsis;
  }
  public void setSynopsis(String synopsis) {
    this.synopsis = synopsis;
  }

  
  /**
   * Year it was released
   **/
  @ApiModelProperty(value = "Year it was released")
  @JsonProperty("yearOfRelease")
  public String getYearOfRelease() {
    return yearOfRelease;
  }
  public void setYearOfRelease(String yearOfRelease) {
    this.yearOfRelease = yearOfRelease;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Movie {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  title: ").append(title).append("\n");
    sb.append("  director: ").append(director).append("\n");
    sb.append("  synopsis: ").append(synopsis).append("\n");
    sb.append("  yearOfRelease: ").append(yearOfRelease).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
