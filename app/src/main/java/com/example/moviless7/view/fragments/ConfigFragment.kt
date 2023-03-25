package com.example.moviless7.view.fragments


import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.moviless7.R
import com.example.moviless7.databinding.FragmentConfigBinding
import com.example.moviless7.databinding.FragmentContentBinding
import com.example.moviless7.model.Config
import com.example.moviless7.viewmodel.ConfigViewModel


class ConfigFragment : Fragment(){

    private lateinit var binding: FragmentConfigBinding

    //Views models
    private val configViewModel: ConfigViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConfigBinding.inflate(inflater, container, false)

        binding.mainColorBtn1.setOnClickListener(::onClick)
        binding.mainColorBtn2.setOnClickListener(::onClick)
        binding.mainColorBtn3.setOnClickListener(::onClick)
        binding.backColorBtn1.setOnClickListener(::onClick)
        binding.backColorBtn2.setOnClickListener(::onClick)
        binding.backColorBtn3.setOnClickListener(::onClick)
        return binding.root
    }

    fun onClick(v: View) {
        val config = Config(
            mainColor = null,
            backColor = null
        )
        val backgroundColor = (v.background as? ColorDrawable)?.color ?: 0
        Log.d(">>>", "onClick: ${backgroundColor}")
        when (v.id) {
            R.id.mainColorBtn1 -> {
                config.mainColor = backgroundColor
            }
            R.id.mainColorBtn2 -> {
                config.mainColor = backgroundColor

            }
            R.id.mainColorBtn3 -> {
                config.mainColor = backgroundColor

            }
            R.id.backColorBtn1 -> {
                config.backColor = backgroundColor

            }
            R.id.backColorBtn2 -> {
                config.backColor = backgroundColor

            }
            R.id.backColorBtn3 -> {
                config.backColor = backgroundColor

            }
        }
        configViewModel.updateConfig(config)

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