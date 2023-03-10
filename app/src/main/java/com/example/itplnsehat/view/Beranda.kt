package com.example.itplnsehat.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.itplnsehat.fragment.Home_Fragment
import com.example.itplnsehat.fragment.Profile_Fragment
import com.example.itplnsehat.R
import com.example.itplnsehat.fragment.JadwalFragment
import kotlinx.android.synthetic.main.activity_beranda.*
import java.util.*

class Beranda : AppCompatActivity() {
    private val fragHome : Fragment = Home_Fragment()
    private val fragProfile : Fragment = Profile_Fragment()
    private val fragJadwal : Fragment = JadwalFragment()

    private val fm : FragmentManager = supportFragmentManager
    private var active : Fragment = fragHome

    private lateinit var menu : Menu
    private lateinit var menuItem : MenuItem

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)

        setupNaviBottom()
    }

    private fun setupNaviBottom() {
        fm.beginTransaction().add(R.id.navi_content, fragProfile).show(fragProfile).commit()
        fm.beginTransaction().add(R.id.navi_content, fragJadwal).show(fragJadwal).commit()
        fm.beginTransaction().add(R.id.navi_content, fragHome).show(fragHome).commit()

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
                R.id.navi_jadwal -> {
                    callFrag(2, fragJadwal)
                }
            }
        }
    }

    private fun callFrag(i: Int, fragment: Fragment) {
        menuItem = menu.getItem(i)
        menuItem.isChecked = true

        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }


}