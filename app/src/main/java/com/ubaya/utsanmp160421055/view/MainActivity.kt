package com.ubaya.utsanmp160421055.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.ubaya.utsanmp160421055.R
import com.ubaya.utsanmp160421055.databinding.ActivityMainBinding
import com.ubaya.utsanmp160421055.viewmodel.userViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var uViewModel: userViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        uViewModel = ViewModelProvider(this).get(userViewModel::class.java)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.hostFragment) as NavHostFragment
        navController = navHostFragment.navController
        if (navController.currentDestination?.id == R.id.loginFragment) {
            binding.navView.visibility = View.GONE
            binding.bottomNav.visibility = View.GONE
        }
        val drawerConfig = AppBarConfiguration(navController.graph, binding.drawerLayout)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerConfig)

        binding.navView.setupWithNavController(navController)
        if(!uViewModel.isUserLogIn()){
            Log.d("Check exception", "Berhasil")
            navController.navigate(R.id.actionItemHomeTologinFragment)
        }
        setupNavigation()
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            navController,
            binding.drawerLayout
        ) || super.onSupportNavigateUp()
    }
    private fun setupNavigation() {
        NavigationUI.setupActionBarWithNavController(this, navController, binding.drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)

        binding.bottomNav.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.loginFragment || destination.id == R.id.registerFragment) {
                binding.navView.visibility = View.GONE
                binding.bottomNav.visibility = View.GONE
            } else {
                binding.navView.visibility = View.VISIBLE
                binding.bottomNav.visibility = View.VISIBLE
            }
        }
    }
}
