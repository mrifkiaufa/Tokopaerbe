package com.aufa.tokopaerbe

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import com.aufa.tokopaerbe.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var binding: FragmentLoginBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding!!.daftarButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        changeColor()
        setUpAction()

        return binding?.root
    }

    private fun changeColor() {
        val text = binding!!.syaratKetentuan.text

        val spannableText = SpannableString(text)

        val primaryColor = ContextCompat.getColor(requireContext(), R.color.primary_container)
        val purple1 = ForegroundColorSpan(primaryColor)
        val purple2 = ForegroundColorSpan(primaryColor)

        spannableText.setSpan(purple1, 37, 55, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableText.setSpan(purple2, 62, 79, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding!!.syaratKetentuan.text = spannableText
    }

    private fun setUpAction(){
//        if (email.isBlank() && password.isBlank()) {
//            masukBtn.isEnabled = false
//        }

        binding!!.masukButton.setOnClickListener{
//            if (!(Patterns.EMAIL_ADDRESS.matcher(email).matches())) {
//                binding!!.validasiEmail.text = "Email tidak valid"
//                binding!!.validasiEmail.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.holo_red_dark))
//            } else {
//                binding!!.validasiEmail.text = "Contoh: test@gmail.com"
//                binding!!.validasiEmail.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.black))
//            }
//
//            if (password.length < 8) {
//                binding!!.validasiPassword.text = "Password tidak valid"
//                binding!!.validasiPassword.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.holo_red_dark))
//            } else {
//                binding!!.validasiPassword.text = "Minimal 8 karakter"
//                binding!!.validasiPassword.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.black))
//            }
            val email = binding!!.emailEditText.text.toString()
            val emailMessage = binding!!.validasiEmail.text.toString()
            val password = binding!!.passwordEditText.text.toString()
            val passwordMessage = binding!!.validasiPassword.text.toString()
            val masukBtn = binding!!.masukButton

            if (!(Patterns.EMAIL_ADDRESS.matcher(email).matches())) {
                binding!!.validasiEmail.text = "Email tidak valid"
                binding!!.validasiEmail.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.holo_red_dark))
            } else if (password.length < 8) {
                binding!!.validasiPassword.text = "Password tidak valid"
                binding!!.validasiPassword.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.holo_red_dark))
            } else {
                it.findNavController().navigate(R.id.action_loginFragment_to_barFragment)
            }
        }
    }
}