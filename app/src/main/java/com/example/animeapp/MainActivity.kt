package com.example.animeapp

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.animeapp.database.AppDatabase
import com.example.animeapp.databinding.ActivityMainBinding
import com.example.animeapp.model.Anime

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.actionMenuToolbar)

        db = Room
            .databaseBuilder(
                this,
                AppDatabase::class.java,
                AppDatabase.DATABASE_NAME
            )
            .allowMainThreadQueries().build()

       // createInitialData()
        binding.animeRecyclerView.layoutManager =
            GridLayoutManager(this, 1, RecyclerView.VERTICAL, false)

        binding.animeRecyclerView.adapter = AnimeAdapter(
            db.animeDao().list(), this, db
        )

        binding.addAnimeButton.setOnClickListener {
            val createBookIntent = Intent(
                this, CreateAnimeActivity::class.java
            )

            startActivity(createBookIntent)
        }
    }

    fun createInitialData() {
        db.run {
            db.animeDao().save(
                Anime("Your Name", "2016", "Romance", "Makoto Shinkai")
            )
            db.animeDao().save(
                Anime("Weathering With You", "2019", "Romance", "Makoto Shinkai")
            )
            db.animeDao().save(
                Anime("Suzume", "2023", "Romance", "Makoto Shinkai")
            )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

   // override fun onOptionsItemSelected(item: MenuItem): Boolean {
     //   when (item.itemId) {
       //     R.id.showCustomersActivityItem -> {
         //       val intent = Intent(
           //   )
             //   startActivity(intent)
            //}
        //}
        //return super.onOptionsItemSelected(item)
    //}

    override fun onResume() {
        super.onResume()

        val adapter = binding.animeRecyclerView.adapter as AnimeAdapter

        adapter.anime = db.animeDao().list()

        adapter.notifyDataSetChanged()
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.anime_context_menu, menu)
    }
}