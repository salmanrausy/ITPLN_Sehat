package com.example.itplnsehat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val tvDaftar = findViewById<TextView>(R.id.register) //mencari id TextView 'register' di file activity_login
        val buttonLogin = findViewById<Button>(R.id.btnLogin) //mencari id Button 'cardSubmit' di file activity_login
        val Username = findViewById<EditText>(R.id.username) //mencari id EditText 'username' di file activity_login
        val Password = findViewById<EditText>(R.id.password) //mencari id EditText 'password' di file activity_login

        tvDaftar.setOnClickListener{
            val intent = Intent(this, Daftar::class.java)
            startActivity(intent)
        }

        buttonLogin.setOnClickListener{
            if (Username.text.toString().isNotEmpty() and Password.text.toString().isNotEmpty()){
                val intent = Intent(this, Beranda::class.java)
                startActivity(intent)
            }

            else {
                val toast = Toast.makeText(applicationContext, "Lengkapi Username dan Password", Toast.LENGTH_LONG)
                toast.show()
            }
        }
    }
}