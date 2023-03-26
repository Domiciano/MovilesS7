package com.example.moviless7.model

import android.graphics.Color

class ConfigRepository {

    var currentConfig: Config? = Config(Color.BLUE, Color.WHITE)

    fun updateConfig(config: Config) {

        config.mainColor?.let {
            currentConfig?.mainColor = it
        }

        config.backColor?.let {
            currentConfig?.backColor = it
        }
    }

}