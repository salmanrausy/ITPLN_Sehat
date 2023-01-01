package com.example.itplnsehat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.itplnsehat.view.Login

class MainActivity : AppCompatActivity() {
    //INI CLASS UNTUK SPLASHSCREEN
    //Deklarasi variabel timer splash muncul
    private val SPLASH_TIME_OUT:Long = 3000
    private lateinit var gambar_loading: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gambar_loading = findViewById(R.id.gambar)

        supportActionBar?.hide()
        setAnimation()

        //Instruksi menjalankan main screen setelah timer splash screen selesai
        Handler().postDelayed({
            val intent = Intent(this@MainActivity, Login::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT)
    }

    private fun setAnimation(){
        val animation = AnimationUtils.loadAnimation(this@MainActivity,R.anim.top_animation)
        gambar_loading.animation = animation
    }
}