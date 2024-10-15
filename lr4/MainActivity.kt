package com.example.lr4

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mainLayout: View
    private lateinit var colorMeaningText: TextView
    private lateinit var dogBreedsListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainLayout = findViewById(R.id.main)
        colorMeaningText = findViewById(R.id.colorMeaningText)
        dogBreedsListView = findViewById(R.id.dogBreedsListView)

        registerForContextMenu(colorMeaningText)

        val dogBreeds = resources.getStringArray(R.array.smartest_dog_breeds)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dogBreeds)
        dogBreedsListView.adapter = adapter

        findViewById<View>(R.id.button1).setOnClickListener { }
        findViewById<View>(R.id.button2).setOnClickListener { startActivity(Intent(this, SecondActivity::class.java)) }
        findViewById<View>(R.id.button3).setOnClickListener { startActivity(Intent(this, ThirdActivity::class.java)) }
    }

    private fun showNavigationDialog(activityClass: Class<*>) {
        AlertDialog.Builder(this)
            .setTitle("Перехід")
            .setMessage("Ви впевнені, що хочете перейти на наступну активність?")
            .setPositiveButton("Так") { _, _ ->
                startActivity(Intent(this, activityClass))
            }
            .setNegativeButton("Ні", null)
            .show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val colorResId = when (item.itemId) {
            R.id.color_gray -> R.color.gray
            R.id.color_blue -> R.color.blue
            R.id.color_brown -> R.color.brown
            R.id.color_purple -> R.color.purple
            R.id.color_red -> R.color.red
            R.id.color_green -> R.color.green
            R.id.color_pink -> R.color.pink
            R.id.color_orange -> R.color.orange
            else -> return super.onOptionsItemSelected(item)
        }
        mainLayout.setBackgroundColor(resources.getColor(colorResId, theme))
        return true
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val colorResId = when (item.itemId) {
            R.id.text_color_gray -> R.color.gray
            R.id.text_color_blue -> R.color.blue
            R.id.text_color_brown -> R.color.brown
            R.id.text_color_purple -> R.color.purple
            R.id.text_color_red -> R.color.red
            R.id.text_color_green -> R.color.green
            R.id.text_color_pink -> R.color.pink
            R.id.text_color_orange -> R.color.orange
            else -> return super.onContextItemSelected(item)
        }
        colorMeaningText.setBackgroundColor(resources.getColor(colorResId, theme))
        return true
    }
}