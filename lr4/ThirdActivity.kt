package com.example.lr4

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {
    private lateinit var mainLayout: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        mainLayout = findViewById(android.R.id.content)

        findViewById<View>(R.id.button1).setOnClickListener { startActivity(Intent(this, MainActivity::class.java)) }
        findViewById<View>(R.id.button2).setOnClickListener { startActivity(Intent(this, SecondActivity::class.java)) }
        findViewById<View>(R.id.button3).setOnClickListener { /* Do nothing, already on ThirdActivity */ }
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
}