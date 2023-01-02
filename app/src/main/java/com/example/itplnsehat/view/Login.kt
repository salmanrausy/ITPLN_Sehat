package com.example.itplnsehat.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.itplnsehat.R
import com.example.itplnsehat.fragment.Home_Fragment
import com.example.itplnsehat.fragment.Profile_Fragment
import com.example.itplnsehat.model.DataHelper

class Login : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val tvDaftar = findViewById<TextView>(R.id.register) //mencari id TextView 'register' di file activity_login
        val buttonLogin = findViewById<Button>(R.id.btnLogin) //mencari id Button 'cardSubmit' di file activity_login
        val Email = findViewById<EditText>(R.id.email) //mencari id EditText 'username' di file activity_login
        val Password = findViewById<EditText>(R.id.password) //mencari id EditText 'password' di file activity_login
        val db = DataHelper(this)
        tvDaftar.setOnClickListener{
            val intent = Intent(this, Daftar::class.java)
            startActivity(intent)
        }

        buttonLogin.setOnClickListener{
            if (Email.text.toString().isNotEmpty() and Password.text.toString().isNotEmpty()) {
                val idUser = db.checkUser(Email.text.toString(),Password.text.toString())
                if (idUser>0){
                    val bundle = Bundle()

//                    val HomeFragment = Home_Fragment()
//                    val fragment : Fragment? = supportFragmentManager.findFragmentByTag(
//                        HomeFragment::class.java.simpleName)
//
//                    if (fragment !is Profile_Fragment){
//                        supportFragmentManager.beginTransaction()
//                            .add(R.id.container_fragment, HomeFragment, Home_Fragment::class.java.simpleName)
//                            .commit()
//                    }
//                    buttonLogin.visibility = View.GONE

                    intent = Intent(this, Home_Fragment::class.java)
                    bundle.putString("iduser", idUser.toString())
                    intent.putExtras(bundle)
                    startActivity(intent)
                }else{
                Toast.makeText(applicationContext,"Email belum terdaftar",Toast.LENGTH_LONG).show()
                }
            }
            else {
                Toast.makeText(applicationContext, "Lengkapi Username dan Password", Toast.LENGTH_LONG).show()
            }
        }
    }
}