package com.example.moviless7.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviless7.model.User
import com.example.moviless7.model.UserRepository

class UserViewModel : ViewModel() {

    private val userRepository = UserRepository()

    private val user = userRepository.currentUser
    val observableUser = MutableLiveData(user)


    fun updateUser(newUser: User) {
        userRepository.updateUser(newUser)
        observableUser.value = userRepository.currentUser

    }

}

