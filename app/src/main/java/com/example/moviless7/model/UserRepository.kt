package com.example.moviless7.model

class UserRepository {

    var currentUser: User? =
        User("Jacobo Garcia", "Telecommunications Engineer", 389, 192, "I am a student", 0)

    fun updateUser(user: User) {

        if (user.name != "") currentUser?.name = user.name

        if (user.career != "") currentUser?.career = user.career

        if (user.description != "") currentUser?.description = user.description

        if (user.photoID != 0) currentUser?.photoID = user.photoID


    }

}



