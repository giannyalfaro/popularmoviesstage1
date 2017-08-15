package movie.popular.stage.networking;

import io.reactivex.Observable;
import movie.popular.stage.data.MovieList;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {

    @GET("3/movie/popular")
    Observable<MovieList> getPopularMovies(@Query("api_key") String apiKey);
}
