package com.aufa.tokopaerbe

import android.os.Bundle
import android.text.Html
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import com.aufa.tokopaerbe.databinding.FragmentRegisterBinding
import com.aufa.tokopaerbe.databinding.FragmentViewPagerBinding


class RegisterFragment : Fragment() {
    private var binding: FragmentRegisterBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)

        binding!!.masukButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }

        setUpAction()

        return binding?.root
    }

    private fun setUpAction(){
//        if (email.isBlank() && password.isBlank()) {
//            registerBtn.isEnabled = false
//        }
        
        binding!!.daftarButton.setOnClickListener{
            val email = binding!!.emailEditText.text.toString()
            val emailMessage = binding!!.validasiEmail.text.toString()
            val password = binding!!.passwordEditText.text.toString()
            val passwordMessage = binding!!.validasiPassword.text.toString()
            val registerBtn = binding!!.daftarButton

            if (!(Patterns.EMAIL_ADDRESS.matcher(email).matches())) {
                binding!!.validasiEmail.text = "Email tidak valid"
                binding!!.validasiEmail.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.holo_red_dark))
            } else if (password.length < 8) {
                binding!!.validasiPassword.text = "Password tidak valid"
                binding!!.validasiPassword.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.holo_red_dark))
            } else {
                it.findNavController().navigate(R.id.action_registerFragment_to_profileFragment)
            }
        }
    }
}