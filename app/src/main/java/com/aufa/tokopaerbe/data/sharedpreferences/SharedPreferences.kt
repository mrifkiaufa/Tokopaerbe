package com.aufa.tokopaerbe.data.sharedpreferences

import android.content.Context

//val sharedPreferenceHelper = module {
//    factory { SharedPreferencesHelper(get()) }
//}

class SharedPreferences(context: Context) {

    private var sharedPreferences = context.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)

    fun setValues(key: String, value: Any?) {
        with(sharedPreferences.edit()) {
            when (value) {
                is String -> putString(key, value)
                is Boolean -> putBoolean(key, value)
                else -> throw IllegalArgumentException("Invalid type of Shared Preferences")
            }
                .apply()
        }
    }

    fun getValue(key: String, defaultValue: Any? = null): Any? {
        with(sharedPreferences) {
            return when (defaultValue) {
                is String -> getString(key, defaultValue)
                is Boolean -> getBoolean(key, defaultValue)
                else -> null
            }
        }
    }

    fun setOnboardingPass(key: String, value: Boolean) {
        with(sharedPreferences.edit()) {
            putBoolean(key, value).apply()
        }
    }

    fun getOnboardingPass(key: String, defaultValue: Boolean = false): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    fun saveTheme(key: String, value: Boolean) {
        with(sharedPreferences.edit()) {
            putBoolean(key, value).apply()
        }
    }

    fun getTheme(key: String, defaultValue: Boolean = false): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    fun removeValue(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }

    fun clearAll(key: String) {
        sharedPreferences.edit().clear().apply()
    }
}