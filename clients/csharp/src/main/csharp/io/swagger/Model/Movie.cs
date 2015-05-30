using System;
using System.Text;
using System.Collections;
using System.Collections.Generic;

namespace io.swagger.Model {
  public class Movie {
    

    /* Movie's id */
    
    public int? Id { get; set; }

    

    /* Title of the movie */
    
    public string Title { get; set; }

    

    /* Who directed the movie */
    
    public string Director { get; set; }

    

    /* Short description about the movie */
    
    public string Synopsis { get; set; }

    

    /* Year it was released */
    
    public string YearOfRelease { get; set; }

    

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
  }
  
  
}