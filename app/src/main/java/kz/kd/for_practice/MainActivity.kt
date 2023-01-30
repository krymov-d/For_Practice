package kz.kd.for_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnBST: Button = findViewById(R.id.btn_bsd)
        btnBST.setOnClickListener {
            BottomSheetDialog().show(supportFragmentManager, null)
        }

        val btnBSTStandard: Button = findViewById(R.id.btn_bsd_standard)
        btnBSTStandard.setOnClickListener {
            val coordinatorLayout: CoordinatorLayout = findViewById(R.id.coordinator)
            coordinatorLayout.isVisible = !coordinatorLayout.isVisible
        }
    }
}