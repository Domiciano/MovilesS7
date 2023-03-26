package com.example.moviless7.view.fragments


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.moviless7.R
import com.example.moviless7.databinding.FragmentContentBinding
import com.example.moviless7.model.Post
import com.example.moviless7.model.User
import com.example.moviless7.viewmodel.PostViewModel
import com.example.moviless7.viewmodel.UserViewModel


class ContentFragment : Fragment() {

    private lateinit var binding: FragmentContentBinding

    //Views
    private val profileButtons = ArrayList<ImageButton>()

    //STATE
    private var photoID: Int = 0

    //View Models
    private val userViewModel: UserViewModel by activityViewModels()
    private val postViewModel: PostViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContentBinding.inflate(inflater, container, false)

        //Referenciar views
        profileButtons.add(binding.profilePhotoBtn1)
        profileButtons.add(binding.profilePhotoBtn2)
        profileButtons.add(binding.profilePhotoBtn3)
        profileButtons.add(binding.profilePhotoBtn4)


        profileButtons.forEach { it.setOnClickListener(::onClick) }

        binding.editInfoBtn.setOnClickListener(::onClick)


        //RecyclerView
        binding.publishBtn.setOnClickListener {
            val comment = binding.commentET.text.toString()
            val post = Post(comment)
            postViewModel.addPost(post)

            Toast.makeText(activity, "Post published", Toast.LENGTH_SHORT).show()

            //Clear fields
            binding.commentET.text.clear()

        }

        return binding.root
    }

    private fun onClick(v: View) {

        profileButtons.forEach { it.setBackgroundColor(Color.BLACK) }
        v.setBackgroundColor(Color.rgb(83, 66, 210))

        when (v.id) {

            binding.profilePhotoBtn1.id -> photoID = R.drawable.face1

            binding.profilePhotoBtn2.id -> photoID = R.drawable.face2

            binding.profilePhotoBtn3.id -> photoID = R.drawable.face3

            binding.profilePhotoBtn4.id -> photoID = R.drawable.face4


            binding.editInfoBtn.id -> {
                val name = binding.nameET.text.toString()
                val carrer = binding.careerET.text.toString()
                val description = binding.descriptionET.text.toString()
                val user = User(name, carrer, 0, 0, description, photoID)
                userViewModel.updateUser(user)

                //Clear fields
                binding.nameET.text.clear()
                binding.careerET.text.clear()
                binding.descriptionET.text.clear()

            }
        }
        Toast.makeText(activity, "User updated", Toast.LENGTH_SHORT).show()
    }


    companion object {
        fun newInstance() = ContentFragment()
    }
}