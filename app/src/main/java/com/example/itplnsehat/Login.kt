package com.example.itplnsehat

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Login : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val tvDaftar = findViewById<TextView>(R.id.register) //mencari id TextView 'register' di file activity_login
        val buttonLogin = findViewById<Button>(R.id.btnLogin) //mencari id Button 'cardSubmit' di file activity_login
        val Email = findViewById<EditText>(R.id.email) //mencari id EditText 'username' di file activity_login
        val Password = findViewById<EditText>(R.id.password) //mencari id EditText 'password' di file activity_login
        val dbhelp=DataHelper(applicationContext)
        val db=dbhelp.readableDatabase
        tvDaftar.setOnClickListener{
            val intent = Intent(this, Daftar::class.java)
            startActivity(intent)
        }

        buttonLogin.setOnClickListener{
            if (Email.text.toString().isNotEmpty() and Password.text.toString().isNotEmpty()) {
                val query = "SELECT * FROM user WHERE email='" + Email.text.toString() + "' AND password='" + Password.text.toString() + "'"
                val rs = db.rawQuery(query, null)
                if (rs.moveToFirst()) {
                    val idUser = rs.getInt(rs.getColumnIndex("id_user"))
                    rs.close()
                    startActivity(Intent(this, Beranda::class.java).putExtra("id_user", idUser))
                }
            }
            else {
                val toast = Toast.makeText(applicationContext, "Lengkapi Username dan Password", Toast.LENGTH_LONG)
                toast.show()
            }
        }
    }
}