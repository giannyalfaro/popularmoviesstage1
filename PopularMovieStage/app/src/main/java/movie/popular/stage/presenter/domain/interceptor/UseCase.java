package movie.popular.stage.presenter.domain.interceptor;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.schedulers.Schedulers;
import movie.popular.stage.presenter.domain.executor.PostExecutionThread;
import movie.popular.stage.presenter.domain.executor.ThreadExecutor;


public abstract class UseCase<T> {

    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;

    private Disposable disposable = Disposables.empty();

    protected UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    /**
     * Builds an {@link Observable} which will be used when executing the current {@link UseCase}.
     */
    protected abstract Observable<T> buildUseCaseObservable();

    /**
     * Executes the current use case.
     */
    @SuppressWarnings("unchecked")
    public <S extends Observer<T> & Disposable> void execute(S useCaseDisposable) {
        execute(this.buildUseCaseObservable(), useCaseDisposable);
    }

    /**
     * Executes the current use case.
     */
    @SuppressWarnings("unchecked")
    public <S extends Observer<T> & Disposable> void execute(Observable<T> observable,
                                                             S useCaseDisposable) {
        this.disposable = observable
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
                .subscribeWith(useCaseDisposable);
    }

    /**
     * Unsubscribes from current {@link Disposable}.
     */
    public void unsubscribe() {
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }

}
