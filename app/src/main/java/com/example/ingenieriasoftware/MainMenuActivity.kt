package com.example.ingenieriasoftware

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.ingenieriasoftware.databinding.ActivityMainMenuBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainMenuActivity : AppCompatActivity(), NewInventoryDialog.NoticeDialogListener {

    private lateinit var binding: ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navigationHost =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main_menu) as NavHostFragment
        val navController = navigationHost.navController

        navView.setupWithNavController(navController)
    }

    override fun onDialogPositiveClick(dialog: DialogFragment) {
        baseContext.let {
            val fragManager = supportFragmentManager
            fragManager.let {
                val current = getVisibleFragment()
                current?.let {
                    fragManager.beginTransaction().detach(it).commit()
                    fragManager.beginTransaction().attach(it).commit()
                }
            }
        }
    }

    fun getVisibleFragment(): Fragment? {
        val fragmentManager: FragmentManager = this@MainMenuActivity.supportFragmentManager
        val fragments: List<Fragment> = fragmentManager.fragments
        for (fragment in fragments) {
            if (fragment.isVisible) return fragment
        }
        return null
    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {
        TODO("Not yet implemented")
    }
}