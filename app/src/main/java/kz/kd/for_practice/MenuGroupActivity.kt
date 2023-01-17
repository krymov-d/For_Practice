package kz.kd.for_practice

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MenuGroupActivity : AppCompatActivity(R.layout.activity_menu_group) {
    private var option = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(findViewById(R.id.tb_menu_group))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_group, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        when (option) {
            0 -> menu?.findItem(R.id.option_1)?.isChecked = true
            1 -> menu?.findItem(R.id.option_2)?.isChecked = true
            2 -> menu?.findItem(R.id.option_3)?.isChecked = true
            3 -> menu?.findItem(R.id.option_4)?.isChecked = true
        }
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.option_1 -> {
                Toast.makeText(this, "Option 1", Toast.LENGTH_SHORT).show()
                option = 0
                true
            }
            R.id.option_2 -> {
                Toast.makeText(this, "Option 2", Toast.LENGTH_SHORT).show()
                option = 1
                true
            }
            R.id.option_3 -> {
                Toast.makeText(this, "Option 3", Toast.LENGTH_SHORT).show()
                option = 2
                true
            }
            R.id.option_4 -> {
                Toast.makeText(this, "Option 4", Toast.LENGTH_SHORT).show()
                option = 3
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}