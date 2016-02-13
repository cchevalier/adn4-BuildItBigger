# adn4-BuildItBigger
adn4-BuildItBigger

by CChevalier, Feb. 2016
  
This README file presents the references I used to complete each requirement and optional task of the Android Developer Nanodegree - Project 4: Build It Bigger  

  
## Requirements 

### Step 1: Create a Java Library  
    Your first task is to create a Java library that provides jokes. Create a new Gradle Java 
    project either using the Android Studio wizard, or by hand. Then introduce a project dependency 
    between your app and the new Java Library. Make the button display a toast showing a joke 
    retrieved from your Java joke telling library.

- Implementation identical to [ud867 /demo 4.01](https://www.udacity.com/course/viewer#!/c-ud867-nd/l-3983839023/m-4326000125)  
- I had a task failed :app:preDexDebug due to Java 1.8 installed on my working dev computer,  
  solution was to [force compilation of the java library to 1.7](https://discussions.udacity.com/t/execution-failed-for-task-app-predexdebug-in-step-1/24243/5)


### Step 2: Create an Android Library
            
    Create an Android Library containing an Activity that will display a joke passed to it as an 
    intent extra. Wire up project dependencies so that the button can now pass the joke from the 
    Java Library to the Android Library.
  
- Implementation based on [ud867 /demo 4.03](https://www.udacity.com/course/viewer#!/c-ud867-nd/l-3983839023/m-4326000126)

            
### Step 3: Create GCE Module

    Instead of pulling jokes directly from our Java library, we'll set up a Google Cloud Endpoints 
    development server, and pull our jokes from there. Introduce a project dependency between your 
    Java library and your GCE module, and modify the GCE starter code to pull jokes from your Java 
    library. Create an Async task to retrieve jokes. Make the button kick off a task to retrieve a
    joke, then launch the activity from your Android Library to display it.
    
#### Google Cloud Endpoints  
- [https://cloud.google.com/endpoints/](https://cloud.google.com/endpoints/)

#### Callback Interface (Useful for testing purpose, see next task)
- [android asynctask sending callbacks to ui](http://stackoverflow.com/questions/9963691/android-asynctask-sending-callbacks-to-ui)  
- [AsyncTask Implementation using callback interface](https://xelsoft.wordpress.com/2014/11/28/asynctask-implementation-using-callback-interface/)


#### Other Course on Google Cloud infrastructure
- [Developing Scalable Apps in Java with Google App Engine](https://www.udacity.com/courses/ud859) [[Code repo on GitHub](https://github.com/udacity/ud859)]
- [Developing Scalable Apps in Python with Google App Engine](https://www.udacity.com/courses/ud858)


### Step 4: Add Functional Tests

    Add code to test that your Async task successfully retrieves a non-empty string. 
    
#### References:
From this [discussion](https://discussions.udacity.com/t/writing-tests-for-async-task/25482):
- [Testable Android AsyncTask](http://www.making-software.com/2012/10/31/testable-android-asynctask/)  
- [How to test AsyncTask in Android](http://marksunghunpark.blogspot.dk/2015/05/how-to-test-asynctask-in-android.html)  


### Step 5: Add a Paid Flavor

    Add free and paid product flavors to your app. Remove the ad (and any dependencies you can) from 
    the paid flavor.
  
- Implementation similar to [exercise 3.08](https://www.udacity.com/course/viewer#!/c-ud867-nd/l-4020658782/e-4330660052/m-4330491250)  
  
  
  
## Optional Tasks


### OT1: Add Interstitial Ad

    Follow these instructions to add an interstitial ad to the free version. Display the add after 
    the user hits the button, but before the joke is shown.

- [Official Interstitial Ad Tutorial](https://developers.google.com/admob/android/interstitial)

### OT2: Add Loading Indicator

    Add a loading indicator (progress bar) that is shown while the joke is being retrieved and 
    disappears when the joke is ready. 
    
- [Suggested tutorial](http://www.tutorialspoint.com/android/android_loading_spinner.htm)

### OT3: Configure Test Task

    To tie it all together, create a Gradle task that:
        1. Launches the GCE local development server
        2. Runs all tests
        3. Shuts the server down again

- Requires both appengine and gradle to run as a daemon (see this [discussion](https://discussions.udacity.com/t/appengine-daemon-dilemma-while-running-app-and-testing/42296))  
- [Stackoverflow: Android gradle task Google Appengine](http://stackoverflow.com/questions/31434928/android-gradle-task-google-appengine)  

