package com.example.moviless7.model

import android.widget.Toast

class UserRepository {

    var currentUser: User? = User("John Doe", "Computer Science", 100, 200, "I am a student", 0)

    fun updateUser(user: User) {

        if (user.name != "") {
            currentUser?.name = user.name
        }

        if (user.career != "") {
            currentUser?.career = user.career
        }

        if (user.description != "") {
            currentUser?.description = user.description
        }






    }

    fun deleteUser() {
        currentUser = null
    }

}



