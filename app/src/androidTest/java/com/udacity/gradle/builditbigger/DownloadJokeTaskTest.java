package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by cch on 12/02/2016.
 *      based on: http://www.making-software.com/2012/10/31/testable-android-asynctask/
 */
public class DownloadJokeTaskTest extends AndroidTestCase implements DownloadJokeTask.OnTaskCompleted {

    CountDownLatch signal;

    public void testResponse() throws InterruptedException {
        signal = new CountDownLatch(1);

        DownloadJokeTask downloadJokeTask = new DownloadJokeTask(this);
        downloadJokeTask.execute();

        signal.await(10, TimeUnit.SECONDS);
    }

    @Override
    public void onDownloadJokeTaskCompleted(String joke) {
        assertTrue(joke.startsWith("(JOKE#"));
        signal.countDown();
    }
}


