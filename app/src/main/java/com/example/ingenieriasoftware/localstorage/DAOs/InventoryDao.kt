package com.example.ingenieriasoftware.localstorage.DAOs

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.ingenieriasoftware.localstorage.entities.Inventory

@Dao
interface InventoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInventory(inventory: Inventory)

    @Query("SELECT * FROM inventories WHERE id = :id")
    suspend fun getInventoryById(id: Int): Inventory?

    @Query("SELECT * FROM inventories")
    suspend fun getAllInventories(): List<Inventory>

    @Update
    suspend fun updateInventory(inventory: Inventory)

    @Delete
    suspend fun deleteInventory(inventory: Inventory)
}