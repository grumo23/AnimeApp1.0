package com.example.animeapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.animeapp.database.dao.AnimeDao
import com.example.animeapp.database.dao.CustomerDao
import com.example.animeapp.database.dao.RentalDao
import com.example.animeapp.model.Anime
import com.example.animeapp.model.Customer
import com.example.animeapp.model.Rental

@Database(entities = [Anime::class, Customer::class, Rental::class], version = 2)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
    companion object {
        val DATABASE_NAME = "Anime"
    }
    abstract fun animeDao(): AnimeDao
    abstract fun customerDao(): CustomerDao
    abstract fun rentalDao(): RentalDao


}
