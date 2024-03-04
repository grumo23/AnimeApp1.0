package com.example.animeapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.animeapp.model.Rental

@Dao
interface RentalDao {

    @Query("select * from rental")
    fun list(): List<Rental>


    @Insert
    fun save(rental: Rental)
}