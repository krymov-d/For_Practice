package kz.kd.for_practice

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class ActivityViewPager1 : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager_1)

        viewPager = findViewById(R.id.viewpager)
        val adapter = MyPagerAdapter()

        viewPager.offscreenPageLimit = 1
        viewPager.currentItem = 2
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                Log.d("App", "onPageScrolled: position=$position, " +
                        "positionOffset=$positionOffset, " +
                        "positionOffsetPixels=$positionOffsetPixels")
            }

            override fun onPageSelected(position: Int) {
                Log.d("App", "onPageSelected: $position")
                Toast.makeText(this@ActivityViewPager1, "onPageSelected: $position", Toast.LENGTH_SHORT).show()
            }

            override fun onPageScrollStateChanged(state: Int) {
                Log.d("App", "onPageScrollStateChanged: $state")
            }
        })
    }

    override fun onDestroy() {
        viewPager.clearOnPageChangeListeners()
        super.onDestroy()
    }
}