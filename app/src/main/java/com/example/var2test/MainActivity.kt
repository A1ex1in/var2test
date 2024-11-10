package com.example.var2test

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var idLogin: EditText
    private lateinit var idPassword: EditText
    private lateinit var crossButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        idLogin = findViewById(R.id.idLogin)
        idPassword = findViewById(R.id.idPassword)
        crossButton = findViewById(R.id.crossButton)

        crossButton.setOnClickListener {
            val login = idLogin.text.toString()
            val password = idPassword.text.toString()

            if(validateCredentials(login, password)) {
                val intent = Intent(this, UserInterface::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_SHORT).show()
            }


        }
    }

    private fun validateCredentials(login: String, password: String): Boolean {
        /*для дальнейшей проверки логина и пароля*/
        return login == "admin" && password == "password"
    }
}