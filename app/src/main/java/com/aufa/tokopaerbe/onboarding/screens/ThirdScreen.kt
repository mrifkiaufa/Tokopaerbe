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
import com.aufa.tokopaerbe.databinding.FragmentThirdScreenBinding
import com.aufa.tokopaerbe.databinding.FragmentViewPagerBinding

class ThirdScreen : Fragment() {
    private var bindingThirdScreen: FragmentThirdScreenBinding? = null
    private var bindingViewPager: FragmentViewPagerBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingThirdScreen = FragmentThirdScreenBinding.inflate(inflater, container, false)
        bindingViewPager = FragmentViewPagerBinding.inflate(inflater, container, false)
        val view = bindingThirdScreen?.root

        val myTextView: TextView? = view?.findViewById(R.id.selanjutnya)
        myTextView?.visibility = View.GONE

        return view
    }
}