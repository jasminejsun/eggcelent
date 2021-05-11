package com.example.eggcelent

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity

class BoiledMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boiled_popup)

        val backButton: ImageButton = findViewById(R.id.back_button)
        val boiledOptionOne: LinearLayout = findViewById(R.id.boiled_option_one_button)
        val boiledOptionTwo: LinearLayout = findViewById(R.id.boiled_option_two_button)
        val boiledOptionThree: LinearLayout = findViewById(R.id.boiled_option_three_button)
        val boiledOptionFour: LinearLayout = findViewById(R.id.boiled_option_four_button)

        backButton.setOnClickListener {
            val intent = Intent(this,MenuActivity::class.java)
            startActivity(intent);
        }

        boiledOptionOne.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }
    }
}