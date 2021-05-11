package com.example.eggcelent

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class SunnySideUpPopupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sunny_side_up_popup)

        val backButton: ImageButton = findViewById(R.id.back_button)
        val sunnySideUpOptionOne: LinearLayout = findViewById(R.id.sunny_side_up_option_one_button)
        val sunnySideUpOptionTwo: LinearLayout = findViewById(R.id.sunny_side_up_option_two_button)

        backButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent);
        }

        sunnySideUpOptionOne.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("INITIAL_SCREEN_ID", 4)
            startActivity(intent)
        }

        sunnySideUpOptionTwo.setOnClickListener {
            val intent = Intent(this, FiveMinuteActivity::class.java)
            intent.putExtra("INITIAL_SCREEN_ID", 4)
            startActivity(intent)
        }
    }
}