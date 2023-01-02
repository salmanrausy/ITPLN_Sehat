package com.example.itplnsehat.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.example.itplnsehat.R
import com.example.itplnsehat.model.DataHelper
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.activity_login.*

class EditProfile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        val db = DataHelper(this)
        val idUser = intent.getStringExtra("idUser").toString()
        val Full_Name = findViewById<EditText>(R.id.fullName_edit) //mencari id EditText 'fullname' di file activity_daftar
        val nomor_edit = findViewById<EditText>(R.id.Nomor_edit) //mencari id EditText 'username_daftar' di file activity_daftar
        val Email = findViewById<EditText>(R.id.Email_edit) //mencari id TextView 'Email' di file activity_daftar
        val born = findViewById<TextView>(R.id.born_edit)
        val getData = db.profile(idUser.toInt())

        Full_Name.setText(getData[0])
        email.setText(getData[1])
        nomor_edit.setText(getData[2])
        born.setText(getData[3])

    }

}