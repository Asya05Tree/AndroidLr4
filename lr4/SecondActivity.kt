package com.example.lr4

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var mainLayout: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        mainLayout = findViewById(R.id.main)

        // Set up navigation buttons
        findViewById<View>(R.id.button1).setOnClickListener { showNavigationDialog(MainActivity::class.java) }
        findViewById<View>(R.id.button2).setOnClickListener {}
        findViewById<View>(R.id.button3).setOnClickListener { showNavigationDialog(ThirdActivity::class.java) }
    }

    private fun showNavigationDialog(activityClass: Class<*>) {
        AlertDialog.Builder(this)
            .setTitle("Перехід")
            .setMessage("Ви впевнені, що хочете перейти на іншу активність?")
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
}