package com.example.moviless7.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviless7.R
import com.example.moviless7.model.Post
import com.example.moviless7.view.MainActivity
import com.example.moviless7.view.lists.PostAdapter
import com.example.moviless7.model.User


class HomeFragment : Fragment(), ContentFragment.OnUserDataChangedListener,
    ContentFragment.OnPostAddedListener {

    private lateinit var profileImage: ImageView
    private lateinit var profileName: TextView
    private lateinit var profileCareer: TextView
    private lateinit var profileDescription: TextView
    private lateinit var profilePostsRV: RecyclerView

    //STATE
    var user = User("Andres Andrade","Ingeniero Telemático", 123, 1823, "Lorem Ipsum", R.drawable.face1)
    private var adapter = PostAdapter()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val root: View = inflater.inflate(R.layout.fragment_home, container, false)
        profileImage = root.findViewById(R.id.profileImage)
        profileName = root.findViewById(R.id.profileName)
        profileCareer = root.findViewById(R.id.profileCareer)

        profilePostsRV = root.findViewById(R.id.profilePostsRV)
        //Poblar el estado de la lista
        profilePostsRV.adapter = adapter
        profilePostsRV.layoutManager = LinearLayoutManager(context)
        profilePostsRV.setHasFixedSize(false)

        profileDescription = root.findViewById(R.id.profileDescription)

        //Poblar el estado

        profileName.text = user.name
        profileCareer.text = user.career
        profileDescription.text = user.description
        profileImage.setImageResource(user.photoID)


        val myactivity = activity as MainActivity


        return root
    }

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onUserDataChanged(user: User) {
        //NUNCA !!!!!!!! Usar la UI
        this.user = user

    }

    override fun onPostAdded(post: Post) {
        //!!NADA DE UI
        this.adapter.posts.add(post)
    }
}