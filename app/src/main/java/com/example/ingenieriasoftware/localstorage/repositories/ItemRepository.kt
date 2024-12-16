package com.example.ingenieriasoftware.localstorage.repositories

import com.example.ingenieriasoftware.localstorage.DAOs.ItemDao
import com.example.ingenieriasoftware.localstorage.entities.Item

class ItemRepository(private val itemDao: ItemDao) {

    suspend fun insertItem(item: Item) {
        itemDao.insertItem(item)
    }

    suspend fun getItemById(id: Int): Item? {
        return itemDao.getItemById(id)
    }

    suspend fun getAllItems(): List<Item> {
        return itemDao.getAllItems()
    }

    suspend fun updateItem(item: Item) {
        itemDao.updateItem(item)
    }

    suspend fun deleteItem(item: Item) {
        itemDao.deleteItem(item)
    }
}