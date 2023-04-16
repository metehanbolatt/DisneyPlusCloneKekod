package com.juniorkekod.disneyplusclonekekod.presentation.moviedetail.tablayout

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2
    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> RecommendedFragment()
            else -> ParticularsFragment()
        }
    }
}