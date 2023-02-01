package kz.kd.for_practice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnOne: Button = findViewById(R.id.viewpager_1)
        btnOne.setOnClickListener{
            val intent = Intent(this, ActivityViewPager1::class.java)
            startActivity(intent)
        }

        val btnTwo: Button = findViewById(R.id.viewpager_2)
        btnTwo.setOnClickListener{
            val intent = Intent(this, ActivityViewPager2::class.java)
            startActivity(intent)
        }
    }
}