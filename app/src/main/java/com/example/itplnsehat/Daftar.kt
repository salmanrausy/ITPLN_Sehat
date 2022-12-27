package com.example.itplnsehat

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class Daftar : AppCompatActivity() {
    private lateinit var tvDatePicker: TextView
    private lateinit var btnDatePicker: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)

        //Find Id Button
        val Button_SignUp = findViewById<Button>(R.id.btn_SignUp) //mencari id Button 'cardSubmit' di file activity_daftar
        btnDatePicker = findViewById<Button>(R.id.btn_DatePicker) //mencari id Button 'cardDatePicker' di file activity_daftar
        //Find Id EditText
        val Full_Name = findViewById<EditText>(R.id.fullName) //mencari id EditText 'fullname' di file activity_daftar
        val nomor_daftar = findViewById<EditText>(R.id.Nomor_daftar) //mencari id EditText 'username_daftar' di file activity_daftar
        val Password_daftar = findViewById<EditText>(R.id.password_daftar) //mencari id EditText 'password_daftar' di file activity_daftar
        val Email = findViewById<EditText>(R.id.Email) //mencari id TextView 'Email' di file activity_daftar
        //Find id TextView
        val myCalendar = Calendar.getInstance()
        val tv_SignIn = findViewById<TextView>(R.id.SignIn_daftar) //mencari id TextView 'SignIn_daftar' di file activity_daftar
        tvDatePicker = findViewById(R.id.born) //mencari id Button 'born' di file activity_daftar

        tv_SignIn.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        Button_SignUp.setOnClickListener{
            if (nomor_daftar.text.toString().isNotEmpty() and
                Password_daftar.text.toString().isNotEmpty() and
                Email.text.toString().isNotEmpty() and
                Full_Name.text.toString().isNotEmpty())
            {
                val user  = User(Full_Name.text.toString(),Email.text.toString(),nomor_daftar.text.toString(), Password_daftar.text.toString())
                val db = DataHelper(this)
                db.insertData(user,getDate(myCalendar))
                val intent = Intent(this, Beranda::class.java)
                startActivity(intent)
            }

            else {
                val toast = Toast.makeText(applicationContext, "Lengkapi Seluruh Data!", Toast.LENGTH_LONG)
                toast.show()
            }
        }


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
    }

    private fun updateLable(myCalendar: Calendar){
        val myformat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myformat, Locale.UK)
        tvDatePicker.setText("Tanggal Lahir : " + sdf.format(myCalendar.time))
    }
    private fun getDate(myCalendar: Calendar): String{
        val myformat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myformat, Locale.UK)
        return sdf.format(myCalendar.time)
    }
}