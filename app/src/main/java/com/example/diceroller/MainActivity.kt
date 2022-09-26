package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var diceImage: ImageView
    private lateinit var rollButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        rollButton.apply {
            setOnClickListener {
                Toast.makeText(this@MainActivity, "Keep rolling", Toast.LENGTH_SHORT).show()
                val diceRoll = Random.nextInt(1, 7)
                diceImage.clickRoll(diceRoll)
            }
        }
    }

    private fun initComponents() {
        diceImage = findViewById(R.id.diceImage)
        rollButton = findViewById(R.id.roll_button)
    }

    private fun ImageView.clickRoll(diceRoll: Int) {
        setImageResource(
            when (diceRoll) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                6 -> R.drawable.dice_6
                else -> R.drawable.empty_dice
            }
        )
    }
}