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

# How long did you spend on this project?
About 3 hours

# Did you make any trade-offs for this project? What would you have done differently with more time?
I will maybe to be faster create a recycler view on Transactions details like label, value pair to display all the items

# What do you think is the weakest part of your project?
Maybe I used too many libraries for a simple project
Have almost none security considerations
No signing config configuration

## Copied in Code
I reused the project structure and the project setup, that save me about 1 hour of coding
Copied:
- NavCommons

## Libraries

### Kotlin
Provides extensions for common libraries that are part of the Android framework
- core_ktx_version = "1.7.0"
- lifecycle_version = "2.4.1"

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
- nav_version = "2.4.2"

### Moshi version
Provides a framework to parse JSONs this library is preferred to be used with Kotlin over GSON
- moshi_version = "1.13.0"

### Logs
Provides a simple abstraction to handle logs. Building Plants for different use cases will abstract
your log framework of implementation details
- timber_version = "5.0.1"

### Dependency injection
Dependency injection framework built over Dagger2 recommended by google and provides best performance
over others. I am not a total fans of Dagger2 but the performance of this library is the best one.
Koin is a good contender, easy to use, lightweight and good enough performance
hilt_version = "2.41"

### UI
- Databinding, I prefer databinding over ViewBinding it is more powerful and the boilerplate code is
  very similar, two way databinding allows to build a reactive UI easily and the nature of the library
  will allow you to do validations in forms super easy
- recycler_view_version = "1.2.1"
- swipe_to_refresh_version = "1.1.0"

## TODO
- Defining Styles.
- Build configurations

## Other classes added
- I used the NavCommons class that I have written for my own projects, just to provide a common
class to handle navigation, transition animations and be able to abstract the Details of the implementation
currently nav controller is the recommended framework but tomorrow... 