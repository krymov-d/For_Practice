package kz.kd.for_practice

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.tb_main))

        val btnNextActivity: Button = findViewById(R.id.btn_next_activity)
        btnNextActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        registerForContextMenu(findViewById(R.id.btn_next_activity))

        val btnPopUp: Button = findViewById(R.id.btn_popup)
        btnPopUp.setOnClickListener {
            val popup = PopupMenu(this, it)
            val inflater: MenuInflater = popup.menuInflater
            inflater.inflate(R.menu.menu_main, popup.menu)
            popup.setOnMenuItemClickListener(this)
            popup.show()
        }

        val btnSubMenu: Button = findViewById(R.id.btn_submenu)
        btnSubMenu.setOnClickListener {
            val intent = Intent(this, SubMenuActivity::class.java)
            startActivity(intent)
        }

        val btnMenuGroup: Button = findViewById(R.id.btn_menu_group)
        btnMenuGroup.setOnClickListener {
            val intent = Intent(this, MenuGroupActivity::class.java)
            startActivity(intent)
        }
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


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
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

    override fun onMenuItemClick(p0: MenuItem?): Boolean {
        return when (p0?.itemId) {
            R.id.menu_close -> {
                Toast.makeText(this, "Close", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_more -> {
                Toast.makeText(this, "More", Toast.LENGTH_SHORT).show()
                true
            }
            else -> false
        }
    }
}