package com.example.viewfragments.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewfragments.Fragments.fragmentFirst
import com.example.viewfragments.Fragments.fragmentSecond
import com.example.viewfragments.Fragments.fragmentThird

class ViewPagerFragmentAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount() = 3


    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> fragmentFirst()
            1-> fragmentSecond()
            2-> fragmentThird()
            else -> fragmentFirst()
        }
    }
}