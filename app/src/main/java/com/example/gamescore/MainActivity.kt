package com.example.gamescore

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var score1 = 0
    private var score2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if (savedInstanceState != null) {
            score1 = savedInstanceState.getInt("score1")
            score2 = savedInstanceState.getInt("score2")
        }

        val textViewScoreTeam1: TextView = findViewById(R.id.textScoreTeam1)
        val textViewScoreTeam2: TextView = findViewById(R.id.textViewScoreTeam2)

        textViewScoreTeam1.text = score1.toString()
        textViewScoreTeam2.text = score2.toString()

        textViewScoreTeam1.setOnClickListener {
            textViewScoreTeam1.text = (++score1).toString()
        }
        textViewScoreTeam2.setOnClickListener {
            textViewScoreTeam2.text = (++score2).toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("score1", score1)
        outState.putInt("score2", score2)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}