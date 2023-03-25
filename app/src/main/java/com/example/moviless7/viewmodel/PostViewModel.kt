package com.example.moviless7.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviless7.model.Post
import com.example.moviless7.model.PostRepository

class PostViewModel: ViewModel() {

    private val postRepository = PostRepository()

    val posts = postRepository.posts
    val observablePosts=MutableLiveData(posts)


    fun addPost(post: Post){
        postRepository.addPost(post)
        observablePosts.value=postRepository.posts
    }






}