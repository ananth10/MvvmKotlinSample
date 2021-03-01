# MvvmKotlinSample :fire:

[![GitHub license](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
![Github Followers](https://img.shields.io/github/followers/ananth10?label=Follow&style=social)
![Twitter Follow](https://img.shields.io/twitter/follow/ananth1006?label=Follow&style=social)

## :scroll: Description
This is developed using MVVM and Kotlin

## :camera_flash: Screenshots
<!-- You can add more screenshots here if you like -->
<img src="/result/search_screen.png" width="260">&emsp;<img src="/result/profile_screen.png" width="260">&emsp;<img src="/result/repo_screen.png" width="260">
<img src="/result/gist_screen.png" width="260">&emsp;<img src="/result/followers_screen.png" width="260">&emsp;<img src="/result/following_screen.png" width="260">

## :snowman: About
This app will fetch user related information such as profile, repos, gists, followers and following from the GitHub API and store it in the mobile local DB its called Room Database. 
So every time user opens app then all data will be retrieved from local database and displayed it in the UI and remote data will be synced with local database as well.
- Clean Architecture
- Offline Support
- Lifecycle aware
- Simple UI

## :house: Architecture 
This application uses MVVM(https://developer.android.com/jetpack/docs/guide#recommended-app-arch) architecture.

![](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)

## :pizza: Components And Libraries :hamburger:

- [Kotlin](https://kotlinlang.org/) - A modern programming language that makes developers happier
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Android architecture components are a collection of libraries that help you design robust, testable, and maintainable apps
  - [Navigation](https://developer.android.com/guide/navigation) - Navigation refers to the interactions that allow users to navigate across, into, and back out from the different pieces of content within your app
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) -  LiveData to build data objects that notify views when the underlying database changes.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - ViewModel stores UI-related data that isn't destroyed on app rotations. 
  - [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - View binding is a feature that allows you to more easily write code that interacts with view. it generates a binding class for each XML layout file present in that module
  - [Room](https://developer.android.com/topic/libraries/architecture/room) - SQLite object mapping library. 
  - [ConstraintLayout](https://developer.android.com/training/constraint-layout) - ConstraintLayout allows you to create large and complex layouts with a flat view hierarchy
- [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) - A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously
- [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/) -   A flow is a type that can emit multiple values sequentially, as opposed to suspend functions that return only a single value
- [Koin](https://insert-koin.io) - a smart Kotlin injection library to keep you focused on your app, not on your tools
- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java
- [Moshi](https://github.com/square/moshi) - Moshi is a modern JSON library for Android and Java. It makes it easy to parse JSON into Java objects
- [Coil](https://coil-kt.github.io/coil/) - An image loading library for Android backed by Kotlin Coroutines

## :bust_in_silhouette: Contact Me 

Need a help?, please send a :email: mail to **ananthababu.v@gmail.com**


## License
```
MIT License

Copyright (c) 2020 Ananthababu

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
