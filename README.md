# swapi-sdk
demo implemented for swapi api

SWAPI-Android-SDK
=================

The SWAPI (Star Wars API) SDK for Android


How to use it
=============

Create a global instance in your application class
```kotlin
public class YourStarWarsApp extends Application {

    @Override
    public void onCreate() {
      super.onCreate();
      //Init star wars api
initializeSwapiClient(this)
    }
    
}


```
In your activities or fragment you may fire every API call you want with just write ```swapiClient``` . 
```kotlin
 
        GlobalScope.launch(Dispatchers.IO) {

            var response = swapiClient.characters(1)
      //in var response you will get results from api            
        }
```

These are the list of apis in below image which is available for use.
![image](https://user-images.githubusercontent.com/86181818/161997026-b43f8cfc-5c37-4dde-9f29-ac6a854b5c9d.png)
