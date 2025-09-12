package com.example.gamescore

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var score1 = 0
    private var score2 = 0

    private lateinit var textViewScoreTeam1: TextView
    private lateinit var textViewScoreTeam2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.d("MainActivity", "Method onCreate")

        textViewScoreTeam1 = findViewById(R.id.textScoreTeam1)
        textViewScoreTeam2 = findViewById(R.id.textViewScoreTeam2)

        if (savedInstanceState != null) {
            score1 = savedInstanceState.getInt("score1")
            score2 = savedInstanceState.getInt("score2")
        }

        updateScore1()
        updateScore2()

        textViewScoreTeam1.setOnClickListener {
            Log.d("MainActivity", "Clicked textViewScoreTeam1")
            score1++
            updateScore1()
        }
        textViewScoreTeam2.setOnClickListener {
            Log.d("MainActivity", "Clicked textViewScoreTeam2")
            score2++
            updateScore2()
        }
    }

    private fun updateScore1() {
        textViewScoreTeam1.text = score1.toString()
    }

    private fun updateScore2() {
        textViewScoreTeam2.text = score2.toString()
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "Method onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "Method onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("MainActivity", "Method onSaveInstanceState")
        outState.putInt("score1", score1)
        outState.putInt("score2", score2)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "Method onDestroy")
    }
}