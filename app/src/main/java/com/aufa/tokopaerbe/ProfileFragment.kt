package com.aufa.tokopaerbe

import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import com.aufa.tokopaerbe.databinding.FragmentProfileBinding
import com.aufa.tokopaerbe.databinding.FragmentRegisterBinding

class ProfileFragment : Fragment() {
    private var binding: FragmentProfileBinding? = null
    private var currentImageUri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        setUpAction()

        binding!!.roundProfile.setOnClickListener {
            
        }

        return binding?.root
    }

    private fun setUpAction(){
        binding!!.selesaiButton.setOnClickListener{
            val nama = binding!!.nameEditText.text.toString()

            if (nama.isNotBlank()) {
                it.findNavController().navigate(R.id.action_profileFragment_to_barFragment)
            }
        }
    }
}