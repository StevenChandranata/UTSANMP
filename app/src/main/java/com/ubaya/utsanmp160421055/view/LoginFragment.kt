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
import androidx.navigation.ui.NavigationUI
import com.ubaya.utsanmp160421055.R
import com.ubaya.utsanmp160421055.databinding.FragmentLoginBinding
import com.ubaya.utsanmp160421055.viewmodel.userViewModel
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var uViewModel: userViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Login"
        val createAccountTextView = binding.buttonTextView
        createAccountTextView.setOnClickListener {
            findNavController().navigate(R.id.actionregisterFragment)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        uViewModel = ViewModelProvider(requireActivity()).get(userViewModel::class.java)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        setHasOptionsMenu(true)
        uViewModel.login()
        binding.btnSignIn.setOnClickListener {
            val username = binding.txtUsername.text.toString()
            val password = binding.txtpassword.text.toString()

            if (uViewModel.checkCredentials(username, password)) {
                val currentUser = uViewModel.getCurrentUserByUsername(username)
                if (currentUser != null) {
                    uViewModel.setCurrentUser(currentUser)
                    val action = LoginFragmentDirections.actionItemHome()
                    Navigation.findNavController(it).navigate(action)
                    Toast.makeText(requireContext(), "Success!", Toast.LENGTH_SHORT).show()
                    binding.txtUsername.text?.clear()
                    binding.txtpassword.text?.clear()
                }
            } else {
                Toast.makeText(requireContext(), "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
