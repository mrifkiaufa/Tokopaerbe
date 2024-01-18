package com.aufa.tokopaerbe.onboarding

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.size
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.aufa.tokopaerbe.R
import com.aufa.tokopaerbe.databinding.FragmentFirstScreenBinding
import com.aufa.tokopaerbe.databinding.FragmentSecondScreenBinding
import com.aufa.tokopaerbe.databinding.FragmentThirdScreenBinding
import com.aufa.tokopaerbe.databinding.FragmentViewPagerBinding
import com.aufa.tokopaerbe.onboarding.screens.FirstScreen
import com.aufa.tokopaerbe.onboarding.screens.SecondScreen
import com.aufa.tokopaerbe.onboarding.screens.ThirdScreen

class ViewPagerFragment : Fragment() {

//    private var bindingFirstScreen: FragmentFirstScreenBinding? = null
//    private var bindingSecondScreen: FragmentSecondScreenBinding? = null
//    private var bindingThirdScreen: FragmentThirdScreenBinding? = null

    private var bindingViewPager: FragmentViewPagerBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingViewPager = FragmentViewPagerBinding.inflate(inflater, container, false)
//        bindingFirstScreen = FragmentFirstScreenBinding.inflate(inflater, container, false)
//        bindingSecondScreen = FragmentSecondScreenBinding.inflate(inflater, container, false)
//        bindingThirdScreen = FragmentThirdScreenBinding.inflate(inflater, container, false)

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

        bindingViewPager!!.lewati.setOnClickListener {
            Log.e("cek", "lewati")
            it.findNavController().navigate(R.id.action_viewPagerFragment_to_loginFragment)
        }

        bindingViewPager!!.onboardButton.setOnClickListener {
            Log.e("cek", "onboard")
            it.findNavController().navigate(R.id.action_viewPagerFragment_to_registerFragment)
        }

        bindingViewPager!!.selanjutnya.setOnClickListener {
            if (bindingViewPager!!.viewPager.currentItem < adapter.itemCount - 1) {
               bindingViewPager!!.viewPager.currentItem += 1
            }
        }

        return bindingViewPager?.root
    }

}