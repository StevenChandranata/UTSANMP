package com.ubaya.utsanmp160421055.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ubaya.utsanmp160421055.databinding.FragmentRegisterBinding
import com.ubaya.utsanmp160421055.viewmodel.userViewModel


class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var uViewModel: userViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Register"
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmit.setOnClickListener {view ->
            val username = binding.txtInputLayoutRegisUsername.editText?.text.toString()
            val firstname = binding.textInputLayoutRegisFirstName.editText?.text.toString()
            val lastname = binding.textInputLayoutRegisLastname.editText?.text.toString()
            val email = binding.textInputLayoutRegisEmail.editText?.text.toString()
            val password = binding.textInputLayoutRegisPassword.editText?.text.toString()
            val ulangPassword = binding.textInputLayoutRegisUlangPassword.editText?.text.toString()
            val imageProfil = binding.textInputLayoutRegisUlangPassword.editText?.text.toString()

            if (username.isEmpty() || firstname.isEmpty() || lastname.isEmpty() || email.isEmpty() || password.isEmpty() || ulangPassword.isEmpty()|| imageProfil.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT)
                    .show()
            } else if (password != ulangPassword) {
                Toast.makeText(requireContext(), "Passwords do not match", Toast.LENGTH_SHORT)
                    .show()
            } else {
                uViewModel = ViewModelProvider(this).get(userViewModel::class.java)
                uViewModel.registerUser(requireContext(), username, firstname, lastname, email, password,imageProfil)

                uViewModel.userRegisLD.observe(viewLifecycleOwner, Observer {
                    if (it == true){
                        val action = RegisterFragmentDirections.actionRegisterloginFragment()
                        Navigation.findNavController(view).navigate(action)
                    }
                })
            }
        }
    }

}


