package com.example.animeapp.model

import androidx.room.Entity
import java.util.Date

@Entity(
    tableName = "rental",
    primaryKeys = ["customerId", "isbn"])
data class Rental(
    val customerId: Int,
    val isbn: String,
    val date: Date
)
