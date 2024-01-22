package com.aufa.tokopaerbe

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.aufa.tokopaerbe.data.sharedpreferences.SharedPreferences
import com.aufa.tokopaerbe.onboarding.OnboardingFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment() {

    private var onboardingPreferences: SharedPreferences? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            delay(1500)
            navigate()
        }
    }

    fun navigate() {
        onboardingPreferences = context?.let {
            SharedPreferences(it)
        }

        val getOnboardingPass = onboardingPreferences?.getOnboardingPass(OnboardingFragment.KEY_ONBOARDING)
        val isOnboardingAppear = if (getOnboardingPass == true) {
            getOnboardingPass
        } else {
            false
        }

        if(isOnboardingAppear) {
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        } else {
            findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
        }
    }
}