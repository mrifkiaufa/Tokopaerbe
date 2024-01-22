package com.aufa.tokopaerbe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatDelegate
import androidx.viewpager2.widget.ViewPager2
import com.aufa.tokopaerbe.data.sharedpreferences.SharedPreferences
import com.aufa.tokopaerbe.postlogin.DashboardFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var onboardingPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onboardingPreferences = SharedPreferences(this)
        getThemeMode()

        supportActionBar?.hide()
    }

    private fun getThemeMode() {
        val themeChecker = onboardingPreferences.getTheme(DashboardFragment.KEY_THEME)
        if (themeChecker) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}