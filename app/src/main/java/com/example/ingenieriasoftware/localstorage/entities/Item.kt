package com.example.ingenieriasoftware.localstorage.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "items")
data class Item(
    @PrimaryKey val id : String = UUID.randomUUID().toString(),
    val code : String,
    val name : String,
    val imageString : String,
    val expirable : Boolean,
    val minAmount : Int
)
