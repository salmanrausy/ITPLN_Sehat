package com.example.itplnsehat.view

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.itplnsehat.R
import kotlinx.android.synthetic.main.activity_buat_jadwal.*

class BuatJadwal : AppCompatActivity(){

    val list_Doctor = arrayOf("Dr. Banner", "Dr. Kamaludin", "Dr. Kehfa", "Dr. Lucille", "Dr. Meisya", "Dr. Strange")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buat_jadwal)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val arrayAdapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, list_Doctor)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object :  AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                HasilPilihan.setText("Anda Memilih : " + list_Doctor[position])
                Toast.makeText(applicationContext, "Anda Memilih : " + list_Doctor[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

}
