package com.example.test.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.test.fragments.PhotosFragment
import com.example.test.fragments.PostsFragment
import com.example.test.fragments.TodosFragment

class TabPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragments = listOf(
        PhotosFragment(),
        PostsFragment(),
        TodosFragment()
    )

    private val titles = listOf("Photos", "Posts", "Todos")

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
