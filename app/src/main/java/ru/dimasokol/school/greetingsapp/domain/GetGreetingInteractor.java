package ru.dimasokol.school.greetingsapp.domain;

import io.reactivex.Single;

public interface GetGreetingInteractor {

    Single<String> getGreeting();

}
