package ru.dimasokol.school.greetingsapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.dimasokol.school.greetingsapp.presentation.GreetingsPresenter;
import ru.dimasokol.school.greetingsapp.presentation.GreetingsView;

public class MainActivity extends AppCompatActivity implements GreetingsView {

    private TextView mGreetingView;
    private GreetingsPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGreetingView = findViewById(R.id.greetings_text);
        mPresenter = ((GreetingsApplication) getApplication()).getPresenter();

        if (savedInstanceState == null) {
            mPresenter.greet();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.attachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.detachView();
    }

    @Override
    public void showGreeting(String message) {
        mGreetingView.setText(message);
    }

    @Override
    public void showProgress() {
        mGreetingView.setText(R.string.loading);
    }

    @Override
    public void showError(String message) {
        mGreetingView.setText(message);
    }
}
