package kz.kd.for_practice

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class StaticStatePagerAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)  {

    private val fragments = mutableListOf<Fragment>()

    init {
        fragments.add(MyFragment.newInstance(0))
        fragments.add(MyFragment.newInstance(1))
        fragments.add(MyFragment.newInstance(2))
        fragments.add(MyFragment.newInstance(3))
        fragments.add(MyFragment.newInstance(4))
        fragments.add(MyFragment.newInstance(5))
        fragments.add(MyFragment.newInstance(6))
        fragments.add(MyFragment.newInstance(7))
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "Title $position"
    }
}