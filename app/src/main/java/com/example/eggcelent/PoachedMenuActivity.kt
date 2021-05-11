package com.example.eggcelent

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class PoachedMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poached_popup)

        val backButton: ImageButton = findViewById(R.id.back_button)
        val poachedOptionOne: LinearLayout = findViewById(R.id.poached_option_one_button)
        val poachedOptionTwo: LinearLayout = findViewById(R.id.poached_option_two_button)
        val poachedOptionThree: LinearLayout = findViewById(R.id.poached_option_three_button)
        val poachedOptionFour: LinearLayout = findViewById(R.id.poached_option_four_button)

        backButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent);
        }

        poachedOptionOne.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("INITIAL_SCREEN_ID", 2)
            startActivity(intent)
        }

        poachedOptionTwo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("cookTime", 8)
            startActivity(intent)
        }

        poachedOptionThree.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("cookTime", 10)
            startActivity(intent)
        }

        poachedOptionFour.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("cookTime", 12)
            startActivity(intent)
        }
    }
}