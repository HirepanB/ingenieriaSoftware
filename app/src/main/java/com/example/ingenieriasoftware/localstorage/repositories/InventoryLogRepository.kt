package com.example.ingenieriasoftware.localstorage.repositories

import com.example.ingenieriasoftware.localstorage.DAOs.InventoryLogDao
import com.example.ingenieriasoftware.localstorage.entities.InventoryLog

class InventoryLogRepository (private val inventoryLogDao: InventoryLogDao) {

    suspend fun insertInventoryLog(inventoryLog: InventoryLog) {
        inventoryLogDao.insertInventoryLog(inventoryLog)
    }

    suspend fun getInventoryLogById(id: Int): InventoryLog? {
        return inventoryLogDao.getInventoryLogById(id)
    }

    suspend fun getAllInventoryLogs(inventoryId: String): List<InventoryLog> {
        return inventoryLogDao.getAllInventoryLogs(inventoryId)
    }

    suspend fun updateInventoryLog(inventoryLog: InventoryLog) {
        inventoryLogDao.updateInventoryLog(inventoryLog)
    }

    suspend fun deleteInventoryLog(inventoryLog: InventoryLog) {
        inventoryLogDao.deleteInventoryLog(inventoryLog)
    }
}