package com.example.moviless7.model

class PostRepository {

    val posts = ArrayList<Post>()

    fun addPost(post: Post) {
        posts.add(post)
    }


}