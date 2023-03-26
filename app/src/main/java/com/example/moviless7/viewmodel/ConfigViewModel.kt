package com.example.moviless7.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviless7.model.Config
import com.example.moviless7.model.ConfigRepository

class ConfigViewModel:ViewModel() {

    private val configRepository = ConfigRepository()

    private val config = configRepository.currentConfig
    val observableConfig = MutableLiveData(config)

    fun updateConfig(config: Config) {
        configRepository.updateConfig(config)
        observableConfig.value = configRepository.currentConfig
    }



}