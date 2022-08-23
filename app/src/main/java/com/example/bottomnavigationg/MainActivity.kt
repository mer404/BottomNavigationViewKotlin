package com.example.bottomnavigationg

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.bottomnavigationg.fragment.ChatFragment
import com.example.bottomnavigationg.fragment.HomeFragment
import com.example.bottomnavigationg.fragment.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var navigation: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(HomeFragment())
        initView()
    }
    private fun initView() {
        navigation = findViewById(R.id.navigation)
        navigation.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                }
                R.id.message -> {
                    loadFragment(ChatFragment())
                }
                R.id.settings -> {
                    loadFragment(SettingFragment())
                }
            }
        }
    }
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}