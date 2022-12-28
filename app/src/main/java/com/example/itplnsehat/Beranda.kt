package com.example.itplnsehat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class Beranda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)
        val db = DataHelper(this)
        val tvBeranda = findViewById<TextView>(R.id.username)
        val tvNama = findViewById<TextView>(R.id.textView2)
        val tvEmail = findViewById<TextView>(R.id.EmailBeranda)
        val tvNomor = findViewById<TextView>(R.id.nomorTelp)
        val tvtglahir = findViewById<TextView>(R.id.tglLahir)
        val value=intent.getStringExtra("iduser")
        tvBeranda.text = "id user = " + value.toString()

        val select = db.selectId(value.toString().toInt())

        tvNama.setText(select[1])
        tvEmail.setText(select[2])
        tvNomor.setText(select[3])
        tvtglahir.setText(select[4])

    }


}