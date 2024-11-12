package com.example.var2test

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.MotionEvent
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
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
    private lateinit var openCloseButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_interface)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        openCloseButton = findViewById(R.id.openCloseButton)
        settingsButton = findViewById(R.id.settingsButton)
        redactProffileButton = findViewById(R.id.redactProffileButton)
        selectKeyButton = findViewById(R.id.selectKeyButton)

        setupButtons()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupButton(button: ImageButton, toastMessage: String) {
        button.setOnClickListener {
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        }

        button.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    startScaleAnimation(v, 1f, 0.9f)
                    true
                }
                MotionEvent.ACTION_UP -> {
                    startScaleAnimation(v, 0.9f, 1f)
                    v.performClick()
                    true
                }
                else -> false
            }
        }
    }

    private fun startScaleAnimation(view: View, fromScale: Float, toScale: Float) {
        val scaleAnimation = ScaleAnimation(
            fromScale, toScale, // Начальный и конечный масштаб по оси X
            fromScale, toScale, // Начальный и конечный масштаб по оси Y
            Animation.RELATIVE_TO_SELF, 0.5f, // Центр анимации по оси X
            Animation.RELATIVE_TO_SELF, 0.5f // Центр анимации по оси Y
        ).apply {
            duration = 100 // Длительность анимации
            fillAfter = true // Сохранять конечное состояние
        }
        view.startAnimation(scaleAnimation)
    }

    private fun setupButtons() {
        setupButton(openCloseButton, "открыть/закрыть")
        setupButton(settingsButton, "тык1")
        setupButton(selectKeyButton, "тык2")
        setupButton(redactProffileButton, "тык3")
    }
}