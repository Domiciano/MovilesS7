package com.example.moviless7.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviless7.R
import com.example.moviless7.databinding.FragmentHomeBinding
import com.example.moviless7.model.Post
import com.example.moviless7.view.MainActivity
import com.example.moviless7.view.lists.PostAdapter
import com.example.moviless7.model.User
import com.example.moviless7.viewmodel.PostViewModel
import com.example.moviless7.viewmodel.UserViewModel


class HomeFragment : Fragment()
     {

    private lateinit var binding: FragmentHomeBinding

    //STATE
    private var user: User? = null
    private val adapter = PostAdapter()

    //View Models
    private val userViewModel: UserViewModel by activityViewModels()
    private val postViewModel: PostViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        this.user = userViewModel.observableUser.value

        //RecyclerView
        binding.profilePostsRV.adapter = adapter
        binding.profilePostsRV.layoutManager = LinearLayoutManager(activity)
        binding.profilePostsRV.setHasFixedSize(true)

        binding.profileName.text = user?.name
        binding.profileCareer.text = user?.career
        binding.profileDescription.text = user?.description
        binding.profileFollowers.text = user?.followers.toString()
        binding.profileFollowing.text = user?.following.toString()
        binding.profileImage.setImageResource(R.drawable.face1)

        userViewModel.observableUser.observe(viewLifecycleOwner) {

            binding.profileName.text = it?.name
            binding.profileCareer.text = it?.career
            binding.profileDescription.text = it?.description
            binding.profileFollowers.text = it?.followers.toString()
            binding.profileFollowing.text = it?.following.toString()


            binding.profileImage.setImageResource(it?.photoID ?: R.drawable.face1)
        }

        postViewModel.observablePosts.observe(viewLifecycleOwner) {
            adapter.posts = it
            adapter.notifyDataSetChanged()
        }


        return binding.root
    }

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }


}