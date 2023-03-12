package com.example.moviless7.view.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.moviless7.R


class ConfigFragment : Fragment(){
    private lateinit var mainColorBtn1: Button
    private lateinit var mainColorBtn2: Button
    private lateinit var mainColorBtn3: Button
    private lateinit var backColorBtn1: Button
    private lateinit var backColorBtn2: Button
    private lateinit var backColorBtn3: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root: View = inflater.inflate(R.layout.fragment_config, container, false)
        mainColorBtn1 = root.findViewById(R.id.mainColorBtn1)
        mainColorBtn2 = root.findViewById(R.id.mainColorBtn2)
        mainColorBtn3 = root.findViewById(R.id.mainColorBtn3)
        backColorBtn1 = root.findViewById(R.id.backColorBtn1)
        backColorBtn2 = root.findViewById(R.id.backColorBtn2)
        backColorBtn3 = root.findViewById(R.id.backColorBtn3)
        mainColorBtn1.setOnClickListener(::onClick)
        mainColorBtn2.setOnClickListener(::onClick)
        mainColorBtn3.setOnClickListener(::onClick)
        backColorBtn1.setOnClickListener(::onClick)
        backColorBtn2.setOnClickListener(::onClick)
        backColorBtn3.setOnClickListener(::onClick)
        return root
    }

    fun onClick(v: View) {
        when (v.id) {
            R.id.mainColorBtn1 -> {

            }
            R.id.mainColorBtn2 -> {

            }
            R.id.mainColorBtn3 -> {

            }
            R.id.backColorBtn1 -> {

            }
            R.id.backColorBtn2 -> {

            }
            R.id.backColorBtn3 -> {

            }
        }
    }

    companion object {
        fun newInstance(): ConfigFragment {
            val fragment = ConfigFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}