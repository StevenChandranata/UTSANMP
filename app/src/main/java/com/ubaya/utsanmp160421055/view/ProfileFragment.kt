package com.ubaya.utsanmp160421055.view

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
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.ubaya.utsanmp160421055.databinding.FragmentProfileBinding
import com.ubaya.utsanmp160421055.model.User
import com.ubaya.utsanmp160421055.viewmodel.userViewModel

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var uViewModel: userViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Profile"
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        uViewModel = ViewModelProvider(requireActivity()).get(userViewModel::class.java)
        uViewModel.currentUserLD.observe(viewLifecycleOwner) { currentUser ->
            if (currentUser != null) {
                updateUI(currentUser)
            }
        }
        binding.btnSave.setOnClickListener {
            val newFirstName = binding.txtChangeFirstName?.text.toString()
            val newLastName = binding.txtChangeLastName?.text.toString()
            val newPassword = binding.txtChangePassword?.text.toString()
            if (newFirstName.isNotEmpty() && newLastName.isNotEmpty() && newPassword.isNotEmpty()) {
                val currentUser = uViewModel.getCurrentUser()
                currentUser?.let {
                    val username = it.username
                    if (username != null) {
                        uViewModel.updateUserProfile(newFirstName, newLastName, newPassword, username)
                        currentUser.firstname = newFirstName
                        currentUser.lastname = newLastName
                        currentUser.password = newPassword
                        uViewModel.setCurrentUser(currentUser)
                    }
                }
            } else {
                Toast.makeText(requireContext(), "Your Profile Credential Cant Be Empty!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnLogOut.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfilelogin()
            Navigation.findNavController(it).navigate(action)
        }
    }
    private fun updateUI(currentUser: User) {
        Picasso.get()
            .load(currentUser.imageProfil)
            .into(binding.imageProfile, object : Callback {
                override fun onSuccess() {
                    binding.progressBarProfile.visibility = View.INVISIBLE
                    binding.imageProfile.visibility = View.VISIBLE
                }

                override fun onError(e: Exception?) {
                    Log.e("picasso_error", e.toString())
                }
            })
        binding.txtProfilUsername.setText(currentUser.username ?: "")
        binding.txtEmail.setText(currentUser.email ?: "")
        binding.txtChangeFirstName.setText(currentUser.firstname ?: "")
        binding.txtChangeLastName.setText(currentUser.lastname ?: "")
        binding.txtChangePassword.setText(currentUser.password ?: "")
    }
}
