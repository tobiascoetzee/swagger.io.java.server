using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using io.swagger.Api;

namespace MovieApiClient
{
    class Program
    {
        static void Main(string[] args)
        {
            var api = new MoviesApi();

            Console.WriteLine("--- Show All Movies ---");

            foreach (var movie in api.getMovieList())
            {
                Console.WriteLine(movie);
            }


            Console.WriteLine("--- Show Movie 2 ---");

            Console.WriteLine(api.getMovieById(2));
        }
    }
}
