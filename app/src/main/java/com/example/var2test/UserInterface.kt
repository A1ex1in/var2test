package com.example.var2test

import android.icu.number.Scale
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
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

        openCloseButton.setOnClickListener {
            Toast.makeText(this, "открыть/закрыть", Toast.LENGTH_SHORT).show()
        }

        openCloseButton.setOnTouchListener { v, event ->
            when (event.action) {
                // При нажатии на кнопку
                MotionEvent.ACTION_DOWN -> {
                    // Анимация уменьшения
                    val scaleDown = ScaleAnimation(
                        1f, 0.9f, // Начальный и конечный масштаб по оси X
                        1f, 0.9f, // Начальный и конечный масштаб по оси Y
                        Animation.RELATIVE_TO_SELF, 0.5f, // Центр анимации по оси X
                        Animation.RELATIVE_TO_SELF, 0.5f // Центр анимации по оси Y
                    )
                    scaleDown.duration = 100 // Длительность анимации
                    scaleDown.fillAfter = true // Сохранять конечное состояние
                    v.startAnimation(scaleDown)
                }
                // При отпускании кнопки
                MotionEvent.ACTION_UP -> {
                    // Анимация увеличения
                    val scaleUp = ScaleAnimation(
                        0.9f, 1f, // Начальный и конечный масштаб по оси X
                        0.9f, 1f, // Начальный и конечный масштаб по оси Y
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f
                    )
                    scaleUp.duration = 100
                    scaleUp.fillAfter = true
                    v.startAnimation(scaleUp)
                }
            }
            false
        }

        settingsButton.setOnClickListener {
            Toast.makeText(this, "тык1", Toast.LENGTH_SHORT).show()
        }

        settingsButton.setOnTouchListener { v, event ->
            when (event.action) {
                // При нажатии на кнопку
                MotionEvent.ACTION_DOWN -> {
                    // Анимация уменьшения
                    val scaleDown = ScaleAnimation(
                        1f, 0.9f, // Начальный и конечный масштаб по оси X
                        1f, 0.9f, // Начальный и конечный масштаб по оси Y
                        Animation.RELATIVE_TO_SELF, 0.5f, // Центр анимации по оси X
                        Animation.RELATIVE_TO_SELF, 0.5f // Центр анимации по оси Y
                    )
                    scaleDown.duration = 100 // Длительность анимации
                    scaleDown.fillAfter = true // Сохранять конечное состояние
                    v.startAnimation(scaleDown)
                }
                // При отпускании кнопки
                MotionEvent.ACTION_UP -> {
                    // Анимация увеличения
                    val scaleUp = ScaleAnimation(
                        0.9f, 1f, // Начальный и конечный масштаб по оси X
                        0.9f, 1f, // Начальный и конечный масштаб по оси Y
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f
                    )
                    scaleUp.duration = 100
                    scaleUp.fillAfter = true
                    v.startAnimation(scaleUp)
                }
            }
            false
        }

        selectKeyButton.setOnClickListener {
            Toast.makeText(this, "тык2", Toast.LENGTH_SHORT).show()
        }

        selectKeyButton.setOnTouchListener { v, event ->
            when (event.action) {
                // При нажатии на кнопку
                MotionEvent.ACTION_DOWN -> {
                    // Анимация уменьшения
                    val scaleDown = ScaleAnimation(
                        1f, 0.9f, // Начальный и конечный масштаб по оси X
                        1f, 0.9f, // Начальный и конечный масштаб по оси Y
                        Animation.RELATIVE_TO_SELF, 0.5f, // Центр анимации по оси X
                        Animation.RELATIVE_TO_SELF, 0.5f // Центр анимации по оси Y
                    )
                    scaleDown.duration = 100 // Длительность анимации
                    scaleDown.fillAfter = true // Сохранять конечное состояние
                    v.startAnimation(scaleDown)
                }
                // При отпускании кнопки
                MotionEvent.ACTION_UP -> {
                    // Анимация увеличения
                    val scaleUp = ScaleAnimation(
                        0.9f, 1f, // Начальный и конечный масштаб по оси X
                        0.9f, 1f, // Начальный и конечный масштаб по оси Y
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f
                    )
                    scaleUp.duration = 100
                    scaleUp.fillAfter = true
                    v.startAnimation(scaleUp)
                }
            }
            false
        }

        redactProffileButton.setOnClickListener {
            Toast.makeText(this, "тык3", Toast.LENGTH_SHORT).show()
        }

        redactProffileButton.setOnTouchListener { v, event ->
            when (event.action) {
                // При нажатии на кнопку
                MotionEvent.ACTION_DOWN -> {
                    // Анимация уменьшения
                    val scaleDown = ScaleAnimation(
                        1f, 0.9f, // Начальный и конечный масштаб по оси X
                        1f, 0.9f, // Начальный и конечный масштаб по оси Y
                        Animation.RELATIVE_TO_SELF, 0.5f, // Центр анимации по оси X
                        Animation.RELATIVE_TO_SELF, 0.5f // Центр анимации по оси Y
                    )
                    scaleDown.duration = 100 // Длительность анимации
                    scaleDown.fillAfter = true // Сохранять конечное состояние
                    v.startAnimation(scaleDown)
                }
                // При отпускании кнопки
                MotionEvent.ACTION_UP -> {
                    // Анимация увеличения
                    val scaleUp = ScaleAnimation(
                        0.9f, 1f, // Начальный и конечный масштаб по оси X
                        0.9f, 1f, // Начальный и конечный масштаб по оси Y
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f
                    )
                    scaleUp.duration = 100
                    scaleUp.fillAfter = true
                    v.startAnimation(scaleUp)
                }
            }
            false
        }
    }
}