package com.example.itplnsehat.view

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.itplnsehat.R
import kotlinx.android.synthetic.main.activity_buat_jadwal.*
import java.text.SimpleDateFormat
import java.util.*

class BuatJadwal : AppCompatActivity(){
    private lateinit var tvDatePicker: TextView
    private lateinit var btnDatePicker: Button

    val list_Doctor = arrayOf("Dr. Banner", "Dr. Kamaludin", "Dr. Kehfa", "Dr. Lucille", "Dr. Meisya", "Dr. Strange")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buat_jadwal)

        //Find Id Button
        btnDatePicker = findViewById<Button>(R.id.btn_DatePickerJadwal) //mencari id Button 'cardDatePicker' di file activity_buat_jadwal

        //Find id TextView
        val myCalendar = Calendar.getInstance()
        tvDatePicker = findViewById(R.id.btn_DatePickerJadwal) //mencari id Button 'born' di file activity_daftar

        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month,
                                                              dayofmonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayofmonth)
            updateLable(myCalendar)
        }
        btnDatePicker.setOnClickListener{
            DatePickerDialog(this, datePicker,
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }

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

    private fun updateLable(myCalendar: Calendar){
        val myformat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myformat, Locale.UK)
        tvDatePicker.setText("Jadwal Anda : " + sdf.format(myCalendar.time))
    }
    private fun getDate(myCalendar: Calendar): String{
        val myformat = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(myformat, Locale.UK)
        return sdf.format(myCalendar.time)
    }

}
