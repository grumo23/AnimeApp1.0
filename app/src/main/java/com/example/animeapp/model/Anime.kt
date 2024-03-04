package com.example.animeapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "anime")
data class Anime(
    @PrimaryKey val titulo: String,
    @ColumnInfo("fecha") val fecha: String,
    @ColumnInfo("descripcion") val descripcion : String,
    @ColumnInfo("autor") val autor: String
)
