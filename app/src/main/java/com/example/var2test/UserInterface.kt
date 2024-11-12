package com.example.var2test

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UserInterface : AppCompatActivity() {

    private lateinit var settingsButton: ImageButton
    private lateinit var redactProffileButton: ImageButton
    private lateinit var selectKeyButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_interface)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        settingsButton = findViewById(R.id.settingsButton)
        redactProffileButton = findViewById(R.id.redactProffileButton)
        selectKeyButton = findViewById(R.id.selectKeyButton)

        settingsButton.setOnClickListener {
            Toast.makeText(this, "тык1", Toast.LENGTH_SHORT).show()
        }
        redactProffileButton.setOnClickListener {
            Toast.makeText(this, "тык3", Toast.LENGTH_SHORT).show()
        }
        selectKeyButton.setOnClickListener {
            Toast.makeText(this, "тык2", Toast.LENGTH_SHORT).show()
        }
    }
}