package com.example.animeapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.animeapp.database.AppDatabase
import com.example.animeapp.databinding.AnimeLayoutBinding
import com.example.animeapp.model.Anime

class AnimeAdapter(
    var anime: List<Anime>,
    val context: Context,
    val db: AppDatabase
) :

    Adapter<AnimeAdapter.ItemViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            layoutInflater.inflate(R.layout.anime_layout, null)
        )
    }

    override fun getItemCount(): Int {
        return anime.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val anime = anime[position]
        val binding = AnimeLayoutBinding.bind(holder.itemView)

        binding.tituloTextView.text = anime.titulo


        binding.fechaTextView.text = anime.fecha

        binding.autorTextView.text = anime.descripcion

        binding.descripcionTextView.text = anime.autor

        binding.deleteAnimeButton.setOnClickListener {
            val deletedRows = db.animeDao().delete(anime.titulo)

            notifyDataSetChanged()
            if (deletedRows == 0) {
                Toast.makeText(context, "No se ha eliminado ningún anime", Toast.LENGTH_LONG).show()
            }
        }
    }
}

