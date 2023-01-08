package com.example.itplnsehat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.itplnsehat.fragment.Home_Fragment

class Spesialis_Pulmonologi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spesialis_pulmonologi)

        //Intent Explicit Back To Fragment_Home
        val cardBack : CardView = findViewById(R.id.card_Back)
        val cardProfile : CardView = findViewById(R.id.cardSpesialis)
        val IV_Back : ImageView = findViewById(R.id.Back)

        IV_Back.setOnClickListener{
            val homeFragment = Home_Fragment()
            val fragment : Fragment? = supportFragmentManager.findFragmentByTag(Home_Fragment::class.java.simpleName)

            if (fragment !is Home_Fragment){
                supportFragmentManager.beginTransaction()
                    .add(R.id.container_pulmonologi, homeFragment, Home_Fragment::class.java.simpleName)
                    .commit()
            }
            cardBack.visibility = View.GONE
            cardProfile.visibility = View.GONE
        }
    }
}