package com.example.itplnsehat.view

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.itplnsehat.R
import com.example.itplnsehat.fragment.Profile_Fragment
import com.example.itplnsehat.model.DataHelper
import com.example.itplnsehat.model.User
import java.text.SimpleDateFormat
import java.util.*

class EditProfile : AppCompatActivity() {

    private lateinit var tvDatePicker: TextView
    private lateinit var btnDatePicker: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        //Find Id Button
        val Button_Save = findViewById<Button>(R.id.btn_Save) //mencari id Button 'btn_Save' di file activity_edit_profile
        val Button_Clear = findViewById<Button>(R.id.btn_clear) //mencari id Button 'btn_Save' di file activity_edit_profile
        btnDatePicker = findViewById<Button>(R.id.btn_DatePicker) //mencari id Button 'cardDatePicker' di file activity_edit_profile

        //Find Id EditText
        val Full_Name = findViewById<EditText>(R.id.fullName_edit) //mencari id EditText 'fullname' di file activity_edit_profile
        val nomor_daftar = findViewById<EditText>(R.id.Nomor_edit) //mencari id EditText 'username_daftar' di file activity_edit_profile
        val Email = findViewById<EditText>(R.id.Email_edit) //mencari id TextView 'Email' di file activity_edit_profile

        //Find id TextView
        val myCalendar = Calendar.getInstance()
        tvDatePicker = findViewById(R.id.born_edit) //mencari id Button 'born' di file activity_edit_profile

        Button_Clear.setOnClickListener {
            Full_Name.setText("")
            nomor_daftar.setText("")
            Email.setText("")
            tvDatePicker.setText("Tanggal Lahir :")
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

        val btn_Back : ImageView = findViewById(R.id.Back)
        btn_Back.setOnClickListener{
            val profileFragment = Profile_Fragment()
            val fragment : Fragment? = supportFragmentManager.findFragmentByTag(Profile_Fragment::class.java.simpleName)

            if (fragment !is Profile_Fragment){
                supportFragmentManager.beginTransaction()
                    .add(R.id.container_fragment, profileFragment, Profile_Fragment::class.java.simpleName)
                    .commit()
            }
            btn_Back.visibility = View.GONE
        }
    }

    private fun updateLable(myCalendar: Calendar){
        val myformat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myformat, Locale.UK)
        tvDatePicker.setText("Tanggal Lahir : " + sdf.format(myCalendar.time))
    }
    private fun getDate(myCalendar: Calendar): String{
        val myformat = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(myformat, Locale.UK)
        return sdf.format(myCalendar.time)
    }

}