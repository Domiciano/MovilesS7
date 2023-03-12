package com.example.moviless7.view.lists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviless7.R
import com.example.moviless7.model.Post
import com.example.moviless7.view.viewholders.PostVH

class PostAdapter : RecyclerView.Adapter<PostVH>() {

    var posts = ArrayList<Post>()




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.postrow, parent, false)
        return PostVH(view)
    }

    override fun onBindViewHolder(holder: PostVH, position: Int) {
        holder.commentRow.text = posts[position].comment
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}