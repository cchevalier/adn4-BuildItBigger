package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.jokedisplay.JokeDisplayActivity;
import com.udacity.gradle.jokes.Joker;

import java.io.IOException;


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

/*
        // External version
        Joker myJoker = new Joker();
        String externalJoke = myJoker.getJoke();
        Toast.makeText(this, externalJoke, Toast.LENGTH_LONG).show();

        // Launch Joke Display Activity
        Intent intent = new Intent(this, JokeDisplayActivity.class);
        intent.putExtra(EXTRA_JOKE, externalJoke);
        startActivity(intent);
*/

        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));
    }


}


// Snippet from: https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    //
                    // https://discussions.udacity.com/t/genymotion-emulator-root-url/27295
                    //
                    // .setRootUrl("http://10.0.2.2:8080/_ah/api/")     // AVD
                    .setRootUrl("http://10.0.3.2:8080/_ah/api/")      // Genymotion
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0].first;
        String name = params[0].second;

        try {
//            return myApiService.sayHi(name).execute().getData();
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }
}