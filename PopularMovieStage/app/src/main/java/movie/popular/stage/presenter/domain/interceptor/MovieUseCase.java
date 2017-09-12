package movie.popular.stage.presenter.domain.interceptor;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import movie.popular.stage.presenter.domain.executor.PostExecutionThread;
import movie.popular.stage.presenter.domain.executor.ThreadExecutor;
import movie.popular.stage.repository.MovieDataRepository;


public class MovieUseCase extends UseCase {


    private MovieDataRepository movieDataRepository;

    @Inject
    protected MovieUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, MovieDataRepository movieDataRepository) {
        super(threadExecutor, postExecutionThread);
        this.movieDataRepository = movieDataRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return null;
    }

    public void getPopularMovies(DisposableObserver movieDisposable) {
        execute(this.movieDataRepository.getPopularMovies(), movieDisposable);

    }

    public void getTopRatedMovies(DisposableObserver movieDisposable) {

        execute(this.movieDataRepository.getTopRatedMovies(), movieDisposable);
    }

    public void getMovieDetail(DisposableObserver movieDisposable, int id) {
        execute(this.movieDataRepository.getMovieDetail(id), movieDisposable);
    }


}
