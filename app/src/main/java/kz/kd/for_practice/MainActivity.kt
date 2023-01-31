package kz.kd.for_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.isVisible

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
    }

    override fun clicked(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}