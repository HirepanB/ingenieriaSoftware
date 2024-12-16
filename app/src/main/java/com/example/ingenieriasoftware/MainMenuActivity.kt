package com.example.ingenieriasoftware

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.ingenieriasoftware.databinding.ActivityMainMenuBinding
import com.example.ingenieriasoftware.localstorage.AppDatabase
import com.example.ingenieriasoftware.localstorage.viewmodels.ItemViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainMenuBinding
    private val itemViewModel: ItemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
        binding = ActivityMainMenuBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navigationHost =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main_menu) as NavHostFragment
        val navController = navigationHost.navController

        navView.setupWithNavController(navController)


            // Consulta inicial: Obtener todos los items
            itemViewModel.getItems { items ->
                if (items.isNotEmpty()) {
                    items.forEach { item ->
                        Log.i("yop", "Item encontrado: " +
                                "id: ${item.id}\n" +
                                "name: ${item.name}\n" +
                                "code: ${item.code}\n" +
                                "expirable: ${item.expirable}\n" +
                                "minAmount: ${item.minAmount}\n" +
                                "imageString: ${item.imageString}")
                    }
                } else {
                    Log.i("yop", "No hay items disponibles.")
                }
            }


        } catch (e: Exception) {
            Log.e("yop", e.message ?: "")
        }
    }
}