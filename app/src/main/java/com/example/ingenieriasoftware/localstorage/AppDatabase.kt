package com.example.ingenieriasoftware.localstorage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ingenieriasoftware.localstorage.DAOs.InventoryDao
import com.example.ingenieriasoftware.localstorage.DAOs.InventoryLogDao
import com.example.ingenieriasoftware.localstorage.DAOs.ItemDao
import com.example.ingenieriasoftware.localstorage.entities.Inventory
import com.example.ingenieriasoftware.localstorage.entities.InventoryLog
import com.example.ingenieriasoftware.localstorage.entities.Item

@Database(entities = [Item::class, Inventory::class, InventoryLog::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao
    abstract fun inventoryDao(): InventoryDao
    abstract fun inventoryLogDao(): InventoryLogDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

}