using System;
using IO.Swagger.Api;

namespace MovieApiClient
{
    class Program
    {
        static void Main(string[] args)
        {
            var api = new MoviesApi();

            Console.WriteLine("--- Show All Movies ---");

            foreach (var movie in api.GetMovieList())
            {
                Console.WriteLine(movie);
            }


            Console.WriteLine("--- Show Movie 2 ---");

            Console.WriteLine(api.GetMovieById(2));
        }
    }
}
