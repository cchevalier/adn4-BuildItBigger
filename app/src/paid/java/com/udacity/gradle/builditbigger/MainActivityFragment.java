package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;

import com.udacity.gradle.jokedisplay.JokeDisplayActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements DownloadJokeTask.OnTaskCompleted {

    public final static String EXTRA_JOKE = "com.udacity.gradle.builditbigger.JOKE";

    Button mTellJokeButton;
    ProgressBar mProgressBar;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mTellJokeButton = (Button) root.findViewById(R.id.tellJokeButton);
        mTellJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tellJoke();
            }
        });

        mProgressBar = (ProgressBar) root.findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.GONE);

/*
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
*/
        return root;
    }

    public void tellJoke(){
        mProgressBar.setVisibility(View.VISIBLE);
        DownloadJokeTask downloadJokeTask = new DownloadJokeTask(this);
        downloadJokeTask.execute();
    }

    @Override
    public void onDownloadJokeTaskCompleted(String joke) {
        mProgressBar.setVisibility(View.GONE);
        startJokeDisplayActivity(joke);
    }

    public void startJokeDisplayActivity(String joke) {
        Intent intent = new Intent(getContext(), JokeDisplayActivity.class);
        intent.putExtra(EXTRA_JOKE, joke);
        startActivity(intent);
    }

}
