package kz.kd.for_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.isVisible
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import kotlin.concurrent.timerTask

class MainActivity : AppCompatActivity(), BSDExpandable.BottomSheetListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnBSD: Button = findViewById(R.id.btn_bsd)
        btnBSD.setOnClickListener {
            BottomSheetDialog().show(supportFragmentManager, null)
        }

        val btnBSDStandard: Button = findViewById(R.id.btn_bsd_standard)
        btnBSDStandard.setOnClickListener {
            val coordinatorLayout: CoordinatorLayout = findViewById(R.id.coordinator)
            coordinatorLayout.isVisible = !coordinatorLayout.isVisible
        }

        val btnBSDExpandable: Button = findViewById(R.id.btn_bsd_expandable)
        btnBSDExpandable.setOnClickListener {
            BSDExpandable().show(supportFragmentManager, null)
        }

        val bNVMain: BottomNavigationView = findViewById(R.id.bnv)
        bNVMain.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.first_page -> {
                    Toast.makeText(this@MainActivity, "Call", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.second_page -> {
                    Toast.makeText(this@MainActivity, "Camera", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        val btnNextActivity: Button = findViewById(R.id.btn_new_activity)
        btnNextActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun clicked(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}