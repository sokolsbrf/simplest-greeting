package ru.dimasokol.school.greetingsapp;

import android.app.Application;

import ru.dimasokol.school.greetingsapp.data.GreetingsRepository;
import ru.dimasokol.school.greetingsapp.data.GreetingsRepositoryImpl;
import ru.dimasokol.school.greetingsapp.domain.GetGreetingInteractor;
import ru.dimasokol.school.greetingsapp.domain.GetGreetingInteractorImpl;
import ru.dimasokol.school.greetingsapp.presentation.GreetingsPresenter;

public class GreetingsApplication extends Application {

    private GreetingsPresenter mPresenter;
    private GetGreetingInteractor mGetGreetingInteractor;
    private GreetingsRepository mGreetingsRepository;

    @Override
    public void onCreate() {
        super.onCreate();

        mGreetingsRepository = new GreetingsRepositoryImpl();
        mGetGreetingInteractor = new GetGreetingInteractorImpl(mGreetingsRepository);
        mPresenter = new GreetingsPresenter(mGetGreetingInteractor);
    }

    public GreetingsPresenter getPresenter() {
        return mPresenter;
    }

}
