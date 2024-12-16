package com.example.ingenieriasoftware.localstorage.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ingenieriasoftware.localstorage.entities.Inventory
import com.example.ingenieriasoftware.localstorage.repositories.InventoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InventoryEntityViewModel @Inject constructor(private val repository: InventoryRepository) : ViewModel() {

    fun addInventory(inventory: Inventory) {
        viewModelScope.launch {
            try {
                repository.insertInventory(inventory)
            } catch (e: IllegalArgumentException) {
                // Manejo del error, por ejemplo: mostrar un mensaje al usuario.
            }
        }
    }

    fun getInventories(callback: (List<Inventory>) -> Unit) {
        viewModelScope.launch {
            val items = repository.getAllInventories()
            callback(items)
        }
    }

    fun updateInventory(inventory: Inventory) {
        viewModelScope.launch {
            try {
                repository.updateInventory(inventory)
            } catch (e: IllegalArgumentException) {
                // Manejo del error
            }
        }
    }

    fun deleteInventory(inventory: Inventory) {
        viewModelScope.launch {
            repository.deleteInventory(inventory)
        }
    }
}