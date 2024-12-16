package com.example.ingenieriasoftware.localstorage.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "inventories")
class Inventory (
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val coverString : String
)