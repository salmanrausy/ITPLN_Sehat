package com.example.itplnsehat

import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.annotation.MenuRes
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_beranda.*
import java.text.SimpleDateFormat
import java.util.*

class Beranda : AppCompatActivity() {

    val fragHome : Fragment = Home_Fragment()
    val fragProfile : Fragment = Profile_Fragment()
    val fm : FragmentManager = supportFragmentManager
    var active : Fragment = fragHome

    private lateinit var menu : Menu
    private lateinit var menuItem : MenuItem

//    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)

        setUpNaviBottom()

        val db = DataHelper(this)
//        val tvNama= findViewById<TextView>(R.id.username)
//        val tvEmail = findViewById<TextView>(R.id.EmailBeranda)
//        val tvNomor = findViewById<TextView>(R.id.nomorTelp)
//        val tvtglahir = findViewById<TextView>(R.id.tglLahir)
        val value=intent.getStringExtra("iduser")

        val select = db.selectId(value.toString().toInt())
        val parser = SimpleDateFormat("yyyy-MM-dd")
        val formatter = SimpleDateFormat("dd.MM.yyyy")
        val date = formatter.format(parser.parse(select[4]))
//        tvNama.setText(select[1])
//        tvEmail.setText(select[2])
//        tvNomor.setText(select[3])
//        tvtglahir.setText(date)

    }

    private fun setUpNaviBottom() {
        fm.beginTransaction().add(R.id.navi_content,
        fragHome).show(fragHome).commit()

        fm.beginTransaction().add(R.id.navi_content,fragProfile).show(fragProfile).commit()

        menu = btn_navi_view.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        btn_navi_view.setOnNavigationItemReselectedListener{
            item ->
            when (item.itemId){
                R.id.navi_home ->{
                    callFrag(0, fragHome)
                }
                R.id.navi_profile -> {
                    callFrag(1, fragProfile)
                }
            }
            false
        }
    }

    private fun callFrag(i:Int, fragment: Fragment){
        menuItem = menu.getItem(i)
        menuItem.isChecked = true

        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }


}