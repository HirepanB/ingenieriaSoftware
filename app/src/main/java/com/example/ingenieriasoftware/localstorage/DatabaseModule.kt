package com.example.ingenieriasoftware.localstorage

import android.content.Context
import com.example.ingenieriasoftware.localstorage.DAOs.InventoryDao
import com.example.ingenieriasoftware.localstorage.DAOs.InventoryLogDao
import com.example.ingenieriasoftware.localstorage.DAOs.ItemDao
import com.example.ingenieriasoftware.localstorage.repositories.InventoryLogRepository
import com.example.ingenieriasoftware.localstorage.repositories.InventoryRepository
import com.example.ingenieriasoftware.localstorage.repositories.ItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideItemDao(database: AppDatabase): ItemDao {
        return database.itemDao()
    }

    @Singleton
    @Provides
    fun provideItemRepository(database: AppDatabase): ItemRepository {
        return ItemRepository(database.itemDao())
    }

    @Singleton
    @Provides
    fun provideInventoryDao(database: AppDatabase): InventoryDao {
        return database.inventoryDao()
    }

    @Singleton
    @Provides
    fun provideInventoryRepository(database: AppDatabase): InventoryRepository {
        return InventoryRepository(database.inventoryDao())
    }

    @Singleton
    @Provides
    fun provideInventoryLogDao(database: AppDatabase): InventoryLogDao {
        return database.inventoryLogDao()
    }

    @Singleton
    @Provides
    fun provideInventoryLogRepository(database: AppDatabase): InventoryLogRepository {
        return InventoryLogRepository(database.inventoryLogDao())
    }
}