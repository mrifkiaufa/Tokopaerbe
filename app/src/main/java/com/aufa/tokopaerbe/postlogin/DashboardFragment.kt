package com.aufa.tokopaerbe.postlogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.aufa.tokopaerbe.data.sharedpreferences.SharedPreferences
import com.aufa.tokopaerbe.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private lateinit var onboardingPreferences: SharedPreferences
    private var bindingDashboard: FragmentDashboardBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingDashboard = FragmentDashboardBinding.inflate(inflater, container, false)

        return bindingDashboard?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onboardingPreferences = SharedPreferences(requireContext())
        val switchTheme = bindingDashboard!!.switchMode

        getTheme()

        switchTheme.setOnCheckedChangeListener { _: CompoundButton?, isChecked: Boolean ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                onboardingPreferences.saveTheme(KEY_THEME, true)
                switchTheme.isChecked = true
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                onboardingPreferences.saveTheme(KEY_THEME, false)
                switchTheme.isChecked = false
            }
        }
    }

    private fun getTheme() {
        val themeChecker = onboardingPreferences.getTheme(KEY_THEME, false)
        bindingDashboard!!.switchMode.isChecked = themeChecker
    }

    companion object {
        const val KEY_THEME = "key_theme"
    }
}