package com.example.moviless7.view

import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.moviless7.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.moviless7.view.fragments.ConfigFragment
import com.example.moviless7.view.fragments.ContentFragment
import com.example.moviless7.view.fragments.HomeFragment


class MainActivity : AppCompatActivity() {

    private lateinit var container: ConstraintLayout
    private lateinit var navigator: BottomNavigationView
    private lateinit var toolbar: Toolbar

    //Fragments
    private lateinit var homeFragment: HomeFragment
    private lateinit var contentFragment: ContentFragment
    private lateinit var configFragment: ConfigFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Referenciar
        toolbar = findViewById(R.id.toolbar)
        container = findViewById(R.id.container)
        navigator = findViewById(R.id.navigator)

        homeFragment = HomeFragment.newInstance()
        contentFragment = ContentFragment.newInstance()
        configFragment = ConfigFragment.newInstance()

        //Relaciones
        contentFragment.listener = homeFragment
        contentFragment.listenerPost = homeFragment

        //Configurar la barra superior
        toolbar.setTitleTextColor(Color.WHITE)
        setSupportActionBar(toolbar)

        //Acción del bottom nav bar
        navigator.setOnItemSelectedListener { option: MenuItem ->
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

    fun showFragment(fragment: Fragment?) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.container, fragment!!)
        transaction.commit()
    }
}