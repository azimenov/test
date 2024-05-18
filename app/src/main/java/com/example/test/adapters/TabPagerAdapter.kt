package com.example.test.adapters

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.test.fragments.JokeFragment
import com.example.test.fragments.ActivityFragment
import com.example.test.fragments.RandomJokeFragment

class TabPagerAdapter(fm: FragmentManager, behavior: Int) : FragmentPagerAdapter(fm, behavior) {

    private val fragments = listOf(
        JokeFragment(),
        RandomJokeFragment(),
        ActivityFragment()
    )

    private val titles = listOf("Jokes", "Random Joke", "Activity")

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }


}
