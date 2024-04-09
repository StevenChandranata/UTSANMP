package com.ubaya.utsanmp160421055.view

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.ubaya.utsanmp160421055.R
import com.ubaya.utsanmp160421055.databinding.FragmentLoginBinding
import com.ubaya.utsanmp160421055.viewmodel.userViewModel

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var ViewModel: userViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Login"
        val createAccountTextView = binding.buttonTextView
        createAccountTextView.setOnClickListener {
            findNavController().navigate(R.id.actionregisterFragment)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewModel = ViewModelProvider(requireActivity()).get(userViewModel::class.java)
        ViewModel.refresh()
        binding.btnSignIn.setOnClickListener {
            val username = binding.txtUsername.text.toString()
            val password = binding.txtpassword.text.toString()

            if (ViewModel.checkCredentials(username, password)) {
                val action = LoginFragmentDirections.actionItemHome()
                Navigation.findNavController(it).navigate(action)
            } else {
                Toast.makeText(requireContext(), "Invalid username or password", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}