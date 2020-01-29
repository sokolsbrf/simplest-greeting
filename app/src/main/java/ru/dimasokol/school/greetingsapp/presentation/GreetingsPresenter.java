package ru.dimasokol.school.greetingsapp.presentation;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import ru.dimasokol.school.greetingsapp.domain.GetGreetingInteractor;

public class GreetingsPresenter {

    private final GetGreetingInteractor mInteractor;
    private GreetingsView mView;

    private String mGreeting = null;
    private Throwable mException = null;
    private Disposable mDisposable;

    public GreetingsPresenter(GetGreetingInteractor interactor) {
        mInteractor = interactor;
    }

    public void attachView(GreetingsView view) {
        mView = view;
        notifyResults();
    }

    public void detachView() {
        mView = null;
    }

    public void greet() {
        mDisposable = mInteractor.getGreeting()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<String>() {
                @Override
                public void accept(String s) throws Exception {
                    mGreeting = s;
                    notifyResults();
                }
            }, new Consumer<Throwable>() {
                @Override
                public void accept(Throwable throwable) throws Exception {
                    mException = throwable;
                    notifyResults();
                }
            });
    }

    private void notifyResults() {
        if (mView != null) {
            if (mException != null) {
                mView.showError(mException.getMessage());
                return;
            }

            if (mGreeting != null) {
                mView.showGreeting(mGreeting);
            } else {
                mView.showProgress();
            }
        }
    }
}
