package com.example.ingenieriasoftware.localstorage.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp
import java.util.UUID

@Entity(tableName = "inventoryLog")
class InventoryLog (
    @PrimaryKey val id : String = UUID.randomUUID().toString(),
    val inventoryId : String,
    val itemId : String,
    val amount : Int,
    val logDate : String,
    val expDate : String
)