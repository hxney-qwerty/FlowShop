package com.example.flowshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.flowersshop.ui.favFragment
import com.example.flowersshop.ui.homeFragment
import com.example.flowersshop.ui.searchFragment
import com.example.flowshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    //lateinit var ch: BottomNavigationView
    private lateinit var frame: FrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(homeFragment())
        binding.nav.setOnItemReselectedListener {
            when(it.itemId) {
                R.id.menu_home -> replaceFragment(homeFragment())
                R.id.search -> replaceFragment(searchFragment())
                R.id.pro -> replaceFragment(favFragment())
                else -> {

                }

            }
            true
        }

    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
        fragmentTransaction.commit()
    }
}