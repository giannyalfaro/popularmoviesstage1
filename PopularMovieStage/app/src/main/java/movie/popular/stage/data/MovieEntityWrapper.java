package movie.popular.stage.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by s3081865 on 14/08/2017.
 */

public class MovieEntityWrapper {

    @SerializedName("results")
    private List<MovieEntity> movies;

    public List<MovieEntity> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieEntity> movies) {
        this.movies = movies;
    }
}
