package ru.dimasokol.school.greetingsapp.presentation;

public interface GreetingsView {

    void showGreeting(String message);
    void showProgress();
    void showError(String message);

}
