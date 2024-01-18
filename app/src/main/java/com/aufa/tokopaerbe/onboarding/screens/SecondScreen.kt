package com.aufa.tokopaerbe.onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.aufa.tokopaerbe.R
import com.aufa.tokopaerbe.databinding.FragmentFirstScreenBinding
import com.aufa.tokopaerbe.databinding.FragmentSecondScreenBinding
import com.aufa.tokopaerbe.databinding.FragmentViewPagerBinding

class SecondScreen : Fragment() {
    private var bindingSecondScreen: FragmentSecondScreenBinding? = null
    private var bindingViewPager: FragmentViewPagerBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingSecondScreen = FragmentSecondScreenBinding.inflate(inflater, container, false)
        bindingViewPager = FragmentViewPagerBinding.inflate(inflater, container, false)
        val view = bindingSecondScreen?.root

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        bindingViewPager!!.selanjutnya.setOnClickListener {
            viewPager?.currentItem = 2
        }

        return view
    }
}