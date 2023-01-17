package kz.kd.for_practice

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity(R.layout.activity_second) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(findViewById(R.id.tb_second))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val btnPreviousActivity: Button = findViewById(R.id.btn_previous_activity)
        btnPreviousActivity.setOnClickListener {
            finish()
        }

        registerForContextMenu(findViewById(R.id.btn_previous_activity))
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_close -> {
                Toast.makeText(this, "Close", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_more -> {
                Toast.makeText(this, "More", Toast.LENGTH_SHORT).show()
                true
            }
            else -> return super.onContextItemSelected(item)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.menu_close -> {
                Toast.makeText(this, "Close", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_more -> {
                Toast.makeText(this, "More", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }
}