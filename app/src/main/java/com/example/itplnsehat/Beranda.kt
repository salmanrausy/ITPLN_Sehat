package com.example.itplnsehat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_beranda.*

class Beranda : AppCompatActivity() {
    val fragHome : Fragment = Home_Fragment()
    val fragProfile : Fragment = Profile_Fragment()
    val fm : FragmentManager = supportFragmentManager
    var active : Fragment = fragHome

    private lateinit var menu : Menu
    private lateinit var menuItem : MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)

        setupNaviBottom()
    }

    private fun setupNaviBottom() {
        fm.beginTransaction().add(R.id.navi_content, fragHome).show(fragHome).commit()
        fm.beginTransaction().add(R.id.navi_content, fragProfile).show(fragProfile).commit()

        menu = btn_navi_view.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        btn_navi_view.setOnNavigationItemReselectedListener{
            item -> when (item.itemId){
                R.id.navi_home -> {
                    callFrag(0, fragHome)
                }
                R.id.navi_profile -> {
                    callFrag(1, fragProfile)
                }
            }
            false
        }

    }

    private fun callFrag(i: Int, fragment: Fragment) {
        menuItem = menu.getItem(i)
        menuItem.isChecked = true

        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }


}