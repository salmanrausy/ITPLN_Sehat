package com.example.itplnsehat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class Beranda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)
        val tvBeranda = findViewById<TextView>(R.id.username)
        val value=intent.getStringExtra("iduser")
        Toast.makeText(applicationContext,"id user = " + value.toString(),Toast.LENGTH_LONG).show()
        tvBeranda.text = "id user = " + value.toString()
    }




}