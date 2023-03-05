# Fetch README
Kyle Bomeisl
3/6/23

App is designed and laid out according to MVVM architecture, fully dependency injected with Hilt, 
includes Unit Testing of each component and UI Instrumented Tests.

The basic layout is as follows:
I. Data Layer

  A. |Data Source| - makes GET calls to https://fetch-hiring.s3.amazonaws.com/hiring.json 
      and deserializes the JSON to lists of data classes
      
  B. |Room Database| - caches the lists of Items from the network GET requests in case the end user 
      has a flaky or no internet connection (in which case the Item list is loaded from the last successful
      network request that has been cached in the database) for a great offline-first user experience
      
  C. |Item Repository| - Mediates the business logic for data retrieval and storage between the Room
      database and Ktor network client to supply the View Model with suspend function methods to 
      refresh the database and keep and up-to-date SharedFlow stream of Items supplied to the View
      Model
      
II. UI Layer 

  A. |View Model| - Upon initialization, attempts to refresh the Room database with a new network GET
      request. If that fails, it supplies the UI State with the last cached successful network response
      cached in the Room database. Provides a StateFlow of the UI State to the Compose UI
      
  B. |Compose UI| - The end user can navigate between the home screen which displays all Items listed with
      the information requested in the instruction specifications in an aesthetically pleasing and intuitive
      way. Features a search bar on the top of the UI where a user can search for specific Items by 'ID.'
      As the user types out an 'ID' integer in the search bar, the UI filters out results in real time to
      only leave Items on the screen that conform to the search parameters
