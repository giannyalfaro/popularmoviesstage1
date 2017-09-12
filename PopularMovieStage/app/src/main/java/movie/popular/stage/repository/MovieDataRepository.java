package movie.popular.stage.repository;

import java.util.List;

import io.reactivex.Observable;
import movie.popular.stage.presenter.domain.MovieRepository;

/**
 * Created by s3081865 on 11/09/2017.
 */

public interface MovieDataRepository {

    Observable<List<MovieRepository>> getPopularMovies();

    Observable<List<MovieRepository>> getTopRatedMovies();

    Observable<MovieRepository> getMovieDetail(int id);
}
