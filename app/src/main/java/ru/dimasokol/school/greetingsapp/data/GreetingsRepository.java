package ru.dimasokol.school.greetingsapp.data;

import androidx.annotation.WorkerThread;

import ru.dimasokol.school.greetingsapp.exceptions.GreetingException;

public interface GreetingsRepository {

    @WorkerThread
    String getGreeting() throws GreetingException;

}
