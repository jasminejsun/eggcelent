package com.example.eggcelent

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val boiledButton: LinearLayout = findViewById(R.id.boiled_menu_button)
        val poachedButton: LinearLayout = findViewById(R.id.poached_menu_button)
        val scrambledButton: LinearLayout = findViewById(R.id.scrambled_menu_button)
        val sunnySideUpButton: LinearLayout = findViewById(R.id.sunny_side_up_menu_button)

        boiledButton.setOnClickListener {
            val intent = Intent(this, BoiledMenuActivity::class.java)
            startActivity(intent);
        }

        poachedButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }
    }
}