package movie.popular.stage.networking;

import io.reactivex.Observable;
import movie.popular.stage.data.MovieEntity;
import movie.popular.stage.data.MovieEntityWrapper;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestApi {

    @GET("3/movie/popular")
    Observable<MovieEntityWrapper> getPopularMovies(@Query("api_key") String apiKey);

    @GET("3/movie/top_rated")
    Observable<MovieEntityWrapper> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("3/movie/{id}")
    Observable<MovieEntity> getMovieDetail(@Path("id") int movieId, @Query("api_key") String apiKey);


}
