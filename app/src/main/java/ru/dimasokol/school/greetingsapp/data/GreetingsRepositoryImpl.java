package ru.dimasokol.school.greetingsapp.data;

import java.util.Random;

import ru.dimasokol.school.greetingsapp.exceptions.GreetingException;

public class GreetingsRepositoryImpl implements GreetingsRepository {

    @Override
    public String getGreeting() throws GreetingException {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (new Random().nextBoolean()) {
            throw new GreetingException("Bad luck!");
        }

        return "Greeting!";
    }

}
