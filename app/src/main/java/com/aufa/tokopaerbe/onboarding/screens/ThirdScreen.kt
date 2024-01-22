package com.aufa.tokopaerbe.onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.aufa.tokopaerbe.R
import com.aufa.tokopaerbe.databinding.FragmentFirstScreenBinding
import com.aufa.tokopaerbe.databinding.FragmentOnboardingBinding
import com.aufa.tokopaerbe.databinding.FragmentThirdScreenBinding

class ThirdScreen : Fragment() {
    private var bindingThirdScreen: FragmentThirdScreenBinding? = null
//    private var bindingViewPager: FragmentOnboardingBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingThirdScreen = FragmentThirdScreenBinding.inflate(inflater, container, false)
        val view = bindingThirdScreen?.root

//        bindingViewPager = FragmentOnboardingBinding.inflate(inflater, container, false)
//
//        if(bindingViewPager!!.viewPager.currentItem == 2) {
//            bindingViewPager!!.selanjutnya.visibility = View.GONE
//        }

        return view
    }
}