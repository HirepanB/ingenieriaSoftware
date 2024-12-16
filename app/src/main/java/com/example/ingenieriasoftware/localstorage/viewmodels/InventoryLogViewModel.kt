package com.example.ingenieriasoftware.localstorage.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ingenieriasoftware.localstorage.entities.InventoryLog
import com.example.ingenieriasoftware.localstorage.repositories.InventoryLogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InventoryLogViewModel @Inject constructor(private val repository: InventoryLogRepository) : ViewModel() {

    fun addInventoryLog(inventoryLog: InventoryLog) {
        viewModelScope.launch {
            try {
                repository.insertInventoryLog(inventoryLog)
            } catch (e: IllegalArgumentException) {
                // Manejo del error, por ejemplo: mostrar un mensaje al usuario.
            }
        }
    }

    fun getInventoryLogs(inventoryId: String, callback: (List<InventoryLog>) -> Unit) {
        viewModelScope.launch {
            val items = repository.getAllInventoryLogs(inventoryId)
            callback(items)
        }
    }

    fun updateInventoryLog(inventoryLog: InventoryLog) {
        viewModelScope.launch {
            try {
                repository.updateInventoryLog(inventoryLog)
            } catch (e: IllegalArgumentException) {
                // Manejo del error
            }
        }
    }

    fun deleteInventoryLog(inventoryLog: InventoryLog) {
        viewModelScope.launch {
            repository.deleteInventoryLog(inventoryLog)
        }
    }
}