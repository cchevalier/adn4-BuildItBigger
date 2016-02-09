# adn4-BuildItBigger
adn4-BuildItBigger

by CChevalier, Feb. 2016


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
            
### Step 3: Create GCE Module

    Instead of pulling jokes directly from our Java library, we'll set up a Google Cloud Endpoints 
    development server, and pull our jokes from there. Introduce a project dependency between your 
    Java library and your GCE module, and modify the GCE starter code to pull jokes from your Java 
    library. Create an Async task to retrieve jokes. Make the button kick off a task to retrieve a
    joke, then launch the activity from your Android Library to display it.
    
#### Google Cloud Endpoints  
- [https://cloud.google.com/endpoints/](https://cloud.google.com/endpoints/)

#### Other Courses
- [Developing Scalable Apps in Python with Google App Engine](https://www.udacity.com/courses/ud858)
- [Developing Scalable Apps in Java with Google App Engine](https://www.udacity.com/courses/ud859) [[Code repo on GitHub](https://github.com/udacity/ud859)]


### Step 4: Add Functional Tests

    Add code to test that your Async task successfully retrieves a non-empty string. For a refresher 
    on setting up Android tests, check out demo 4.09.

### Step 5: Add a Paid Flavor

    Add free and paid product flavors to your app. Remove the ad (and any dependencies you can) from 
    the paid flavor.

