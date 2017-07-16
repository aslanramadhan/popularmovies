package id.encryptsc.popularmovies.utils;

import id.encryptsc.popularmovies.data.Movies;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by aslanramadhan
 */

public interface MovieApiServices {
    @GET("/movie/popular")
    void getPopularMovies(Callback<Movies.MovieResluts> pop);
    @GET("/movie/top_rated")
    void getTopRated(Callback<Movies.MovieResluts> tr);
}
