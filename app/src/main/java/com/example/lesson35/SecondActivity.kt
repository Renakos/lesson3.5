package com.example.lesson35

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson35.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private val games = mutableListOf<BestFootballGame>()
    private val gameListAdapter = GameListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_second)

        fillGameList()
        setupRecyclerView()
    }


    private fun fillGameList() {
        games.apply {
            add(BestFootballGame(R.drawable.game1, "FC24"))
            add(BestFootballGame(R.drawable.game2, "EFootball24"))
            add(BestFootballGame(R.drawable.game3, "FootballManager23"))
            add(BestFootballGame(R.drawable.game1, "FC24"))
            add(BestFootballGame(R.drawable.game2, "EFootball24"))
            add(BestFootballGame(R.drawable.game3, "FootballManager23"))
            add(BestFootballGame(R.drawable.game1, "FC24"))
            add(BestFootballGame(R.drawable.game2, "EFootball24"))
            add(BestFootballGame(R.drawable.game3, "FootballManager23"))
        }
    }

    private fun setupRecyclerView() {
        binding.RV.adapter = gameListAdapter
        gameListAdapter.setData(games)
    }
}