package ru.dimasokol.school.greetingsapp.domain;

import java.util.concurrent.Callable;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import ru.dimasokol.school.greetingsapp.data.GreetingsRepository;

public class GetGreetingInteractorImpl implements GetGreetingInteractor {

    private final GreetingsRepository mRepository;

    public GetGreetingInteractorImpl(GreetingsRepository repository) {
        mRepository = repository;
    }

    @Override
    public Single<String> getGreeting() {
        return Single.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return mRepository.getGreeting();
            }
        }).subscribeOn(Schedulers.io());
    }

}
