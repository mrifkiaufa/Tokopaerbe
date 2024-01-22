package com.aufa.tokopaerbe.onboarding.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.aufa.tokopaerbe.R
import com.aufa.tokopaerbe.databinding.FragmentFirstScreenBinding
import com.aufa.tokopaerbe.databinding.FragmentOnboardingBinding

class FirstScreen : Fragment() {

    private var bindingFirstScreen: FragmentFirstScreenBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingFirstScreen = FragmentFirstScreenBinding.inflate(inflater, container, false)
        val view = bindingFirstScreen?.root

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        return view
    }
}