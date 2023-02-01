package kz.kd.for_practice

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class ActivityViewPager2: AppCompatActivity() {

    private lateinit var viewPager2: ViewPager
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_viewpager_2)

        viewPager2 = findViewById(R.id.viewpager_2)
        tabLayout = findViewById(R.id.tab_layout)
        val adapter = StaticStatePagerAdapter(supportFragmentManager)
        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 1
        tabLayout.setupWithViewPager(viewPager2)

    }
}