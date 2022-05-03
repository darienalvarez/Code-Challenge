# Code Challenge

# Requirements
- You must setup java 11 to be able to build the project.
- Targeting SDK level 32, make sure you have the latest SDK installed.

# Build tools
Required to compile the project
- build_gradle_version = "7.1.2"
- gradle_plugin_version = "1.6.10"

# Steps to run the app
- Import the project in Android Studio.
- Select a phone emulator (the app should not run on tables)
- Run the app

# What areas of the app did you focus on?
Focused on defining model including DTOs and Json parser classes. Trying to maintain separation of concerns
ViewModel and logic. Using MVVM architecture pattern and single state for handling screen.
Using coil for image loading and catching.
Defining simple layouts and Recycler view adapters. Using DiffUtil to load items nicely

# What was the reason for your focus? What problems were you trying to solve?
Defining DTOs and Json Parsers 
 - Allow to have light weigh classes at the business level. 
 - Helps to change the parsing library if is required without affecting all the code.
 - Simplier to add Persistence layer without modifying the rest of the code.
ViewModels to implement the business logic and the requirements.
Using MVVM architecture pattern and single state for the screen.
 - The screen elements displayed using a single state
Coil for image loading and taking advantage of databinding to make the code simple, also provides classes for memory and disk cache
Defining simple layouts and diffutil to avoid extra processing on reloading elements on the recycler view

# How long did you spend on this project?
About 6 hours

# Did you make any trade-offs for this project? What would you have done differently with more time?
More tests

# What do you think is the weakest part of your project?
Sorting the list is hardcoded.
Maybe I used too many libraries for a simple project
Have almost none security considerations
No signing config configuration

# Did you copy any code or dependencies? Please make sure to attribute them here!

## Copied in Code
I reused the project structure and the project setup, that save me about 1 hour of coding
Just updated some libraries and added a new library for pull to refresh
Copied:
- api.adapter package but the EmployeeTypeAdapter.kt
- api.exception and removed code for handle response error body

## Libraries

### Kotlin
Provides extensions for common libraries that are part of the Android framework
- core_ktx_version = "1.7.0"

### UI
Allows integration with Material design themes
- appcompat_version = "1.4.1"
  Material design components
- material_version = "1.5.0"
  Provides constraint layout to be used (preferred and required in this code challenge)
- constraintlayout_version = "2.1.3"

### Navigation controller
Provides a framework to handle the navigation in Android projects, integrated with safeargs will
allow a easy environment to handle navigation and parameters between fragments
- nav_version = "2.3.5"

### Network
Provides a framework to handle REST services or other remote services
- retrofit_version = "2.9.0"
  Provides libraries for HTTP protocol in different versions and allow custom configuration that
  are not available in retrofit like interceptors and authenticator to handle properly 401s
- okhttp_version = "4.9.0"

### Moshi version
Provides a framework to parse JSONs this library is preferred to be used with Kotlin over GSON
- moshi_version = "1.13.0"

### Coil
Library used to async download and display images into imageviews, this library was chosen since
is very simple to use, lightweight and integrated with kotlin coroutines. I also was about to use
Glide or Picasso but in this small project was not required
- coil_version = "2.0.0-rc02"

### Logs
Provides a simple abstraction to handle logs. Building Plants for different use cases will abstract
your log framework of implementation details
- timber_version = "5.0.1"

### Dependency injection
Dependency injection framework built over Dagger2 recommended by google and provides best performance
over others. I am not a total fans of Dagger2 but the performance of this library is the best one.
Koin is a good contender, easy to use, lightweight and good enough performance
hilt_version = "2.38.1"

### UI
- Databinding, I prefer databinding over ViewBinding it is more powerful and the boilerplate code is
  very similar, two way databinding allows to build a reactive UI easily and the nature of the library
  will allow you to do validations in forms super easy
- recycler_view_version = "1.2.1"
- swipe_to_refresh_version = "1.1.0"

# Is there any other information you’d like us to know?

## TODO
- Defining Styles.
- Build configurations

## Other classes added
- I used the NavCommons class that I have written for my own projects, just to provide a common
class to handle navigation, transition animations and be able to abstract the Details of the implementation
currently nav controller is the recommended framework but tomorrow... 