package com.aufa.tokopaerbe.postlogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.aufa.tokopaerbe.R
import com.aufa.tokopaerbe.databinding.FragmentBarBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class BarFragment : Fragment() {

    private var binding: FragmentBarBinding? = null
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBarBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment = childFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        binding!!.navView.setupWithNavController(navController)

        val navView: BottomNavigationView = binding!!.navView

        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.navigation_dashboard, R.id.navigation_store, R.id.navigation_wishlist, R.id.navigation_transaction
        ).build()

        navView.setupWithNavController(navController)
    }
}