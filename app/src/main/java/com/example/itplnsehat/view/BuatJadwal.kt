package com.example.itplnsehat.view

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.itplnsehat.R
import com.example.itplnsehat.model.DataHelper
import com.example.itplnsehat.model.Jadwal
import java.text.SimpleDateFormat
import java.util.*

class BuatJadwal : AppCompatActivity(){
    private lateinit var tvDatePicker: TextView
    private lateinit var btnDatePicker: Button

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buat_jadwal)
        val db = DataHelper(this)
        val list_Doctor = arrayOf("", "Dr. Banner", "Dr. Kamaludin", "Dr. Kehfa", "Dr. Lucille", "Dr. Meisya", "Dr. Strange")
        val bundle :Bundle ?=intent.extras
        val idUser = bundle!!.getString("iduser")
        val btnSave : Button = findViewById(R.id.btn_Save)
        val btnCancel : Button = findViewById(R.id.btn_clear)
        val edKeterangan : EditText = findViewById(R.id.edtKeterangan)

        //Find Id Button
        btnDatePicker = findViewById(R.id.btn_DatePickerJadwal) //mencari id Button 'cardDatePicker' di file activity_buat_jadwal

        //Find id TextView
        val myCalendar = Calendar.getInstance()
        tvDatePicker = findViewById(R.id.JadwalAnda) //mencari id Button 'born' di file activity_daftar

        val datePicker = DatePickerDialog.OnDateSetListener { _, year, month,
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
        var getIdDokter = 0
        val spinner = findViewById<Spinner>(R.id.spinner)
        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, list_Doctor)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object :  AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                getIdDokter = position
//                HasilPilihan.setText("Anda Memilih : " + list_Doctor[position])
//                Toast.makeText(applicationContext, "Anda Memilih : " + list_Doctor[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        btnSave.setOnClickListener {
            val jadwal = Jadwal(getIdDokter.toString(),edKeterangan.text.toString(),getDate(myCalendar))
            db.insertJadwal(jadwal,idUser)
            val bundle = Bundle()
            val intent = Intent(this, Beranda::class.java)
            bundle.putString("iduser", idUser.toString())
            intent.putExtras(bundle)
            startActivity(intent)
        }

        btnCancel.setOnClickListener {
            spinner.setSelection(0)
            tvDatePicker.setText("")
            edKeterangan.setText("")

        }
    }


    private fun updateLable(myCalendar: Calendar){
        val myformat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myformat, Locale.UK)
        tvDatePicker.text = "Jadwal Anda : " + sdf.format(myCalendar.time)
    }
    private fun getDate(myCalendar: Calendar): String{
        val myformat = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(myformat, Locale.UK)
        return sdf.format(myCalendar.time)
    }

}
