package com.aufa.tokopaerbe.onboarding

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.aufa.tokopaerbe.R
import com.aufa.tokopaerbe.data.sharedpreferences.SharedPreferences
import com.aufa.tokopaerbe.databinding.*
import com.aufa.tokopaerbe.onboarding.screens.FirstScreen
import com.aufa.tokopaerbe.onboarding.screens.SecondScreen
import com.aufa.tokopaerbe.onboarding.screens.ThirdScreen

class OnboardingFragment : Fragment() {

//    private var bindingFirstScreen: FragmentFirstScreenBinding? = null
//    private var bindingSecondScreen: FragmentSecondScreenBinding? = null
//    private var bindingThirdScreen: FragmentThirdScreenBinding? = null

    private var bindingViewPager: FragmentOnboardingBinding? = null
    private var onboardingPreferences: SharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingViewPager = FragmentOnboardingBinding.inflate(inflater, container, false)

        return bindingViewPager?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onboardingPreferences = context?.let {
            SharedPreferences(it)
        }

        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        bindingViewPager!!.viewPager.adapter = adapter

        if(bindingViewPager!!.viewPager.currentItem == 2) {
            bindingViewPager!!.selanjutnya.visibility = View.GONE
        }

        bindingViewPager!!.lewati.setOnClickListener {
            onboardingPreferences?.setOnboardingPass(KEY_ONBOARDING, true)

            it.findNavController().navigate(R.id.action_viewPagerFragment_to_loginFragment)
        }

        bindingViewPager!!.onboardButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_viewPagerFragment_to_registerFragment)
        }

        bindingViewPager!!.selanjutnya.setOnClickListener {
            if (bindingViewPager!!.viewPager.currentItem < adapter.itemCount - 1) {
                bindingViewPager!!.viewPager.currentItem += 1
            }
        }
    }

    companion object {
        const val KEY_ONBOARDING = "key_onboarding"
    }
}