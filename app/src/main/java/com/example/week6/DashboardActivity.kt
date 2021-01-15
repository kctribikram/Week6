package com.example.week6


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.example.week6.Adapter.ViewPageAdapter
import com.example.week6.Fragments.AboutFragment
import com.example.week6.Fragments.AddFragment
import com.example.week6.Fragments.HomeFragment

class DashboardActivity : AppCompatActivity() {
    private lateinit var lstTitle: ArrayList<String>
    private lateinit var lstFragments:ArrayList<Fragment>
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        viewPager=findViewById(R.id.viewPager)
        tabLayout=findViewById(R.id.tabLayout)
        populateList()
        val adapter= ViewPageAdapter(lstFragments,supportFragmentManager,lifecycle)
        viewPager.adapter=adapter
        TabLayoutMediator(tabLayout,viewPager){tab,position ->
            tab.text=lstTitle[position]
        }.attach()

    }
    private fun populateList(){
        lstTitle= ArrayList<String>()
        lstTitle.add("Home")
        lstTitle.add("Add")
        lstTitle.add("About")
        lstFragments= ArrayList<Fragment>()
        lstFragments.add(HomeFragment())
        lstFragments.add(AddFragment())
        lstFragments.add(AboutFragment())

    }
}
