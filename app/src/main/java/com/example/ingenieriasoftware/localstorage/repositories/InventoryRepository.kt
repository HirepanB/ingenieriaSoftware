package com.example.ingenieriasoftware.localstorage.repositories

import com.example.ingenieriasoftware.localstorage.DAOs.InventoryDao
import com.example.ingenieriasoftware.localstorage.entities.Inventory
import javax.inject.Inject

class InventoryRepository (private val inventoryDao: InventoryDao) {

    suspend fun insertInventory(inventory: Inventory) {
        inventoryDao.insertInventory(inventory)
    }

    suspend fun getInventoryById(id: Int): Inventory? {
        return inventoryDao.getInventoryById(id)
    }

    suspend fun getAllInventories(): List<Inventory> {
        return inventoryDao.getAllInventories()
    }

    suspend fun updateInventory(inventory: Inventory) {
        inventoryDao.updateInventory(inventory)
    }

    suspend fun deleteInventory(inventory: Inventory) {
        inventoryDao.deleteInventory(inventory)
    }
}