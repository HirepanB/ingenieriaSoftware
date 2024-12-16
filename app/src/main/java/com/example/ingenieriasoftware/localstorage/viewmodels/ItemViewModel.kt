package com.example.ingenieriasoftware.localstorage.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ingenieriasoftware.localstorage.entities.Item
import com.example.ingenieriasoftware.localstorage.repositories.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(private val repository: ItemRepository) : ViewModel() {
    fun addItem(item: Item) {
        viewModelScope.launch {
            try {
                repository.insertItem(item)
            } catch (e: IllegalArgumentException) {
                // Manejo del error, por ejemplo: mostrar un mensaje al usuario.
            }
        }
    }

    fun getItems(callback: (List<Item>) -> Unit) {
        viewModelScope.launch {
            val items = repository.getAllItems()
            callback(items)
        }
    }

    fun updateItem(item: Item) {
        viewModelScope.launch {
            try {
                repository.updateItem(item)
            } catch (e: IllegalArgumentException) {
                // Manejo del error
            }
        }
    }

    fun deleteItem(item: Item) {
        viewModelScope.launch {
            repository.deleteItem(item)
        }
    }
}