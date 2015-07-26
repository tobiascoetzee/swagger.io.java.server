using System;
using System.Text;
using System.Collections;
using System.Collections.Generic;
using System.Runtime.Serialization;
using Newtonsoft.Json;

namespace IO.Swagger.Model {

  /// <summary>
  /// All the details about a movie
  /// </summary>
  [DataContract]
  public class Movie {
    
    /* Movie's id */
    [DataMember(Name="id", EmitDefaultValue=false)]
    public int? Id { get; set; }

    
    /* Title of the movie */
    [DataMember(Name="title", EmitDefaultValue=false)]
    public string Title { get; set; }

    
    /* Who directed the movie */
    [DataMember(Name="director", EmitDefaultValue=false)]
    public string Director { get; set; }

    
    /* Short description about the movie */
    [DataMember(Name="synopsis", EmitDefaultValue=false)]
    public string Synopsis { get; set; }

    
    /* Year it was released */
    [DataMember(Name="yearOfRelease", EmitDefaultValue=false)]
    public string YearOfRelease { get; set; }

    

    /// <summary>
    /// Get the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()  {
      var sb = new StringBuilder();
      sb.Append("class Movie {\n");
      
      sb.Append("  Id: ").Append(Id).Append("\n");
      
      sb.Append("  Title: ").Append(Title).Append("\n");
      
      sb.Append("  Director: ").Append(Director).Append("\n");
      
      sb.Append("  Synopsis: ").Append(Synopsis).Append("\n");
      
      sb.Append("  YearOfRelease: ").Append(YearOfRelease).Append("\n");
      
      sb.Append("}\n");
      return sb.ToString();
    }

    /// <summary>
    /// Get the JSON string presentation of the object
    /// </summary>
    /// <returns>JSON string presentation of the object</returns>
    public string ToJson() {
      return JsonConvert.SerializeObject(this, Formatting.Indented);
    }

}
  
  
}