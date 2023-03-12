package com.example.moviless7.view.fragments


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.moviless7.R
import com.example.moviless7.databinding.FragmentContentBinding
import com.example.moviless7.model.Post

import com.example.moviless7.model.User


class ContentFragment : Fragment() {


    //Observers
    var listener: OnUserDataChangedListener? = null
    var listenerPost : OnPostAddedListener? = null

    //Views
    private val profileButtons = ArrayList<ImageButton>();
    private lateinit var binding: FragmentContentBinding

    //STATE
    var photoID: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentContentBinding.inflate(inflater, container, false)
        val root = binding.root

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
            listenerPost?.let {
                it.onPostAdded(post)
            }
        }

        return root
    }

    fun onClick(v: View) {
        //La variable v que recibe este método es el view al que se le hace click

        profileButtons.forEach { it.setBackgroundColor(Color.BLACK) }
        v.setBackgroundColor(Color.rgb(83, 66, 210))

        when (v.id) {
            R.id.profilePhotoBtn1 -> {
                photoID = R.drawable.face1
            }
            R.id.profilePhotoBtn2 -> {
                photoID = R.drawable.face2
            }
            R.id.profilePhotoBtn3 -> {
                photoID = R.drawable.face3
            }
            R.id.profilePhotoBtn4 -> {
                photoID = R.drawable.face4
            }
            R.id.editInfoBtn -> {
                val name = binding.nameET.text.toString()
                val carrer = binding.careerET.text.toString()
                val description = binding.descriptionET.text.toString()
                val user = User(name, carrer, 0, 0, description, photoID)
                listener?.let {
                    it.onUserDataChanged(user)
                }

            }
        }
    }

    interface OnUserDataChangedListener {
        fun onUserDataChanged(user: User)
    }

    interface OnPostAddedListener {
        fun onPostAdded(post: Post)
    }

    companion object {
        fun newInstance(): ContentFragment {
            val fragment = ContentFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}