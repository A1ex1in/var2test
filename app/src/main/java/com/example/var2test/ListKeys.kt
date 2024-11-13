package com.example.var2test

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListKeys : AppCompatActivity() {
    private lateinit var addKeyButton: Button
    private lateinit var listKeys: ListView
    private lateinit var adapter: ArrayAdapter<String>
    private var items: MutableList<String> = mutableListOf()
    private var itemCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_keys)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val mainLayout = findViewById<View>(R.id.main)
        addKeyButton = findViewById(R.id.addKeyButton)
        listKeys = findViewById(R.id.listKey)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        listKeys.adapter = adapter

        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Обработка нажатия на кнопку
        addKeyButton.setOnClickListener {
            showAddKeyDialog()
        }
    }
    private fun showAddKeyDialog() {
        // Создаем EditText для ввода ключа
        val input = EditText(this)
        val dialog = AlertDialog.Builder(this)
            .setTitle("Добавить ключ")
            .setMessage("Введите ключ:")
            .setView(input)
            .setPositiveButton("Добавить") { _, _ ->
                val newItem = input.text.toString()
                if (newItem.isNotBlank()) {
                    items.add(newItem)
                    adapter.notifyDataSetChanged()
                }
            }
            .setNegativeButton("Отмена") { dialog, _ -> dialog.cancel() }
            .create()

        dialog.show()
    }
}