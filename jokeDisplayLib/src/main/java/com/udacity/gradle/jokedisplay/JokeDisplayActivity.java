package com.udacity.gradle.jokedisplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    public final static String EXTRA_JOKE = "com.udacity.gradle.builditbigger.JOKE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        Intent intent = getIntent();
        String joke = intent.getStringExtra(EXTRA_JOKE);

        TextView jokeText = (TextView) findViewById(R.id.jokeTextView);
        jokeText.setText(joke);
    }
}
