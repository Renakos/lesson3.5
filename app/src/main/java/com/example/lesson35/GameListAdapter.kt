package com.example.lesson35

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson35.databinding.ItemGameBinding

class GameListAdapter : RecyclerView.Adapter<GameListAdapter.GameViewHolder>() {
    private var games = listOf<BestFootballGame>()
    fun setData(data: List<BestFootballGame>) {
        games = data
    }

    class GameViewHolder(private val binding: ItemGameBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(game: BestFootballGame) = with(binding) {
            ivGameCover.setImageResource(game.image)
            tvGameTitle.text = game.name
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val binding = ItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        notifyDataSetChanged()
        return GameViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return games.size
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.onBind(games[position])
        notifyDataSetChanged()
    }
}