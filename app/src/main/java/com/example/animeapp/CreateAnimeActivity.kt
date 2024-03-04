package com.example.animeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.animeapp.database.AppDatabase
import com.example.animeapp.databinding.ActivityCreateAnimeBinding
import com.example.animeapp.model.Anime

class CreateAnimeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateAnimeBinding

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAnimeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = Room
            .databaseBuilder(
                this,
                AppDatabase::class.java,
                AppDatabase.DATABASE_NAME
            )
            .allowMainThreadQueries().build()

        binding.saveButton.setOnClickListener{
            val titulo = binding.tituloEditText.text.toString()
            val fecha = binding.fechaEditText.text.toString()
            val descripcion = binding.descripcionEditText.text.toString()
            val autor = binding.autorEditText.text.toString()

            val anime = Anime(
                titulo = titulo,
                fecha = fecha,
                descripcion = descripcion,
                autor = autor
            )

            db
                .animeDao()
                .save(anime)


            finish()
        }
    }
}
