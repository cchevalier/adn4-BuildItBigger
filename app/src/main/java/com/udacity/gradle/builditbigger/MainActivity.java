package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.udacity.gradle.jokedisplay.JokeDisplayActivity;
import com.udacity.gradle.jokes.Joker;


public class MainActivity extends ActionBarActivity {

    public final static String EXTRA_JOKE = "com.udacity.gradle.builditbigger.JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){

/*
        // Local version
        String localJoke = "Three guys, stranded on a desert island, find a magic lantern containing a genie, who grants them each one wish. " +
                "The first guy wishes he was off the island and back home. The second guy wishes the same. " +
                "The third guy says 'I’m lonely. I wish my friends were back here.'";
        Toast.makeText(this, localJoke, Toast.LENGTH_LONG).show();
*/

        // External version
        Joker myJoker = new Joker();
        String externalJoke = myJoker.getJoke();
        Toast.makeText(this, externalJoke, Toast.LENGTH_LONG).show();

        // Launch Joke Display Activity
        Intent intent = new Intent(this, JokeDisplayActivity.class);
        intent.putExtra(EXTRA_JOKE, externalJoke);
        startActivity(intent);

    }


}
