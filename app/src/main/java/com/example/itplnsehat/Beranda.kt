package com.example.itplnsehat

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class Beranda : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)
        val db = DataHelper(this)
        val tvNama= findViewById<TextView>(R.id.username)
        val tvEmail = findViewById<TextView>(R.id.EmailBeranda)
        val tvNomor = findViewById<TextView>(R.id.nomorTelp)
        val tvtglahir = findViewById<TextView>(R.id.tglLahir)
        val value=intent.getStringExtra("iduser")

        val select = db.selectId(value.toString().toInt())
        val parser = SimpleDateFormat("yyyy-MM-dd")
        val formatter = SimpleDateFormat("dd.MM.yyyy")
        val date = formatter.format(parser.parse(select[4]))
        tvNama.setText(select[1])
        tvEmail.setText(select[2])
        tvNomor.setText(select[3])
        tvtglahir.setText(date)

    }


}