package com.example.ingenieriasoftware.localstorage.DAOs

import androidx.room.*
import com.example.ingenieriasoftware.localstorage.entities.Item

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: Item)

    @Query("SELECT * FROM items WHERE id = :id")
    suspend fun getItemById(id: Int): Item?

    @Query("SELECT * FROM items")
    suspend fun getAllItems(): List<Item>

    @Update
    suspend fun updateItem(item: Item)

    @Delete
    suspend fun deleteItem(item: Item)
}