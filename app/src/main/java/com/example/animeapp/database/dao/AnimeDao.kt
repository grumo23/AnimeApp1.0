package com.example.animeapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.animeapp.model.Anime

@Dao
interface AnimeDao {

    @Query("SELECT * FROM anime")
    fun list(): List<Anime>

    @Query("DELETE FROM anime WHERE titulo=:titulo")
    fun delete(titulo: String): Int

    @Query("SELECT * FROM anime WHERE autor=:autor")
    fun listAuthorAnime(autor: String): List<Anime>

    @Insert
    fun save(anime: Anime)
}