package com.example.ingenieriasoftware.localstorage.DAOs

import androidx.room.*
import com.example.ingenieriasoftware.localstorage.entities.InventoryLog

@Dao
interface InventoryLogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInventoryLog(inventoryLog: InventoryLog)

    @Query("SELECT * FROM inventoryLog WHERE id = :id")
    suspend fun getInventoryLogById(id: Int): InventoryLog?

    @Query("SELECT * FROM inventoryLog WHERE inventoryId = :inventoryId")
    suspend fun getAllInventoryLogs(inventoryId : String): List<InventoryLog>

    @Update
    suspend fun updateInventoryLog(inventoryLog: InventoryLog)

    @Delete
    suspend fun deleteInventoryLog(inventoryLog: InventoryLog)
}