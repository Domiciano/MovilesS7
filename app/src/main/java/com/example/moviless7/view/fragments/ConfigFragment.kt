package com.example.moviless7.view.fragments


import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.moviless7.databinding.FragmentConfigBinding
import com.example.moviless7.model.Config
import com.example.moviless7.viewmodel.ConfigViewModel


class ConfigFragment : Fragment() {

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

    private fun onClick(v: View) {

        val config = Config(
            mainColor = null,
            backColor = null
        )

        val color = (v.background as? ColorDrawable)?.color ?: 0

        when (v.id) {
            binding.mainColorBtn1.id -> config.mainColor = color
            binding.mainColorBtn2.id -> config.mainColor = color
            binding.mainColorBtn3.id -> config.mainColor = color
            binding.backColorBtn1.id -> config.backColor = color
            binding.backColorBtn2.id -> config.backColor = color
            binding.backColorBtn3.id -> config.backColor = color
        }

        configViewModel.updateConfig(config)

    }

    companion object {
        fun newInstance() = ConfigFragment()
    }
}