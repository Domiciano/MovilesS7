package com.example.moviless7.view

import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.moviless7.R
import com.example.moviless7.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.moviless7.view.fragments.ConfigFragment
import com.example.moviless7.view.fragments.ContentFragment
import com.example.moviless7.view.fragments.HomeFragment


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }


    //Fragments
    private  val homeFragment: HomeFragment= HomeFragment.newInstance()
    private  val contentFragment: ContentFragment= ContentFragment.newInstance()
    private  val configFragment: ConfigFragment= ConfigFragment.newInstance()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        //Configurar la barra superior
        binding.toolbar.setTitleTextColor(Color.WHITE)
        setSupportActionBar(binding.toolbar)

        //Acción del bottom nav bar
        binding.navigator.setOnItemSelectedListener { option: MenuItem ->
            when (option.itemId) {
                R.id.home -> showFragment(homeFragment)
                R.id.content -> showFragment(contentFragment)
                R.id.config -> showFragment(configFragment)
            }
            true
        }

        //Inicialmente mostrar la homeFragment
        showFragment(homeFragment)
    }

    private fun showFragment(fragment: Fragment?) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.container, fragment!!)
        transaction.commit()
    }
}