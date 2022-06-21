# AndroidTask🌱
Simple App for the implementation of Paging 3 Library (Android Jetpack)

## About Paging3 Library🌻
The Paging 3 library, a part the new set of Android Jetpack libraries, provides a robust way of paginating large sets of data in Android whether it is loaded from a room database or from a network layer.

The library provides 3 different utilities for loading paginated data:

- Solely from a local Room DB.
- Solely from a webservice.
- From a webservice while storing it in a Room Database for offline use (combination of the above).


## Tech stack🦾
Kotlin - First class and official programming language for Android development.

Different Android Jetpack libraries with RoomDatabase implementation.

## UI of the App 🤓

## Package and files Structure💥

    com.taskwork            # Root Package
    .
    ├── adapter               # For item storage
    |   ├── MainAdapter       # For storing View in Room Database
    |
    ├── dao
    |   ├── ItemDao           # For queries in room database
    |
    ├── database               # For room database
    │   └── ItemDatabase    
    |   └── MainViewModel 
    |
    ├── model
    │   └── Item 
    |
    └── pagination             # for implementing Paging3
    │   └── MainLoadStateAdapter
    |   └── MainPagingSource
    
    
   
   
## Contribute 🤝

If you want to contribute to this library, you're always welcome!

    
    
 



