package movie.popular.stage.repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import movie.popular.stage.data.MovieEntity;
import movie.popular.stage.data.MovieEntityWrapper;
import movie.popular.stage.networking.RestApi;
import movie.popular.stage.presenter.domain.MovieRepository;

/**
 * Created by s3081865 on 11/09/2017.
 */

public class MovieDataRepositoryImpl implements MovieDataRepository {

    final private String KEY = "7255a7d39d292e28fd6446d00ce9579b";
    private final RestApi restApi;

    @Inject
    public MovieDataRepositoryImpl(RestApi restApi) {
        this.restApi = restApi;
    }


    @Override
    public Observable<List<MovieRepository>> getPopularMovies() {
        return restApi.getPopularMovies(KEY).map(this::toRepositoryList);
    }


    @Override
    public Observable<List<MovieRepository>> getTopRatedMovies() {
        return restApi.getTopRatedMovies(KEY).map(this::toRepositoryList);
    }


    @Override
    public Observable<MovieRepository> getMovieDetail(int id) {
        return restApi.getMovieDetail(id, KEY).map(this::toRepository);
    }


    private MovieRepository toRepository(MovieEntity e) {
        MovieRepository repository = new MovieRepository();

        repository.setId(e.getId());
        repository.setName(e.getName());
        repository.setPosterUrl(e.getPosterUrl());
        return repository;
    }

    private List<MovieRepository> toRepositoryList(MovieEntityWrapper wrapper) {
        List<MovieRepository> list = new ArrayList<>();
        for (MovieEntity e : wrapper.getMovies()) {
            list.add(this.toRepository(e));
        }

        return list;

    }
}
