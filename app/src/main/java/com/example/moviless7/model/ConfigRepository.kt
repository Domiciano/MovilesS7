package com.example.moviless7.model

import android.graphics.Color

class ConfigRepository {

    var currentConfig: Config? = Config(Color.BLUE, Color.WHITE)

    fun updateConfig(config: Config) {
        if (config.mainColor != null) {
            currentConfig?.mainColor = config.mainColor
        }
        if (config.backColor != null) {
            currentConfig?.backColor = config.backColor
        }
    }

    fun deleteConfig() {
        currentConfig = null
    }
}