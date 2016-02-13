package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by cch on 10/02/2016
 *
 *      based on GC Endpoints handling using AsyncTask
 *      See: https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
 *
 */
public class DownloadJokeTask extends AsyncTask<Void, Void, String> {

    public interface OnTaskCompleted {
        void onDownloadJokeTaskCompleted(String joke);
    }

    public final static String EXTRA_JOKE = "com.udacity.gradle.builditbigger.JOKE";

    private static MyApi myApiService = null;
    private OnTaskCompleted listener;


    public DownloadJokeTask(OnTaskCompleted listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(Void... params) {

        // Slow down a bit in order to see the progress bar...
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // Running on AVD vs Genymotion, see https://discussions.udacity.com/t/genymotion-emulator-root-url/27295
                    // .setRootUrl("http://10.0.2.2:8080/_ah/api/")     // AVD
                    .setRootUrl("http://10.0.3.2:8080/_ah/api/")      // Genymotion
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
//        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        listener.onDownloadJokeTaskCompleted(result);
    }
}
