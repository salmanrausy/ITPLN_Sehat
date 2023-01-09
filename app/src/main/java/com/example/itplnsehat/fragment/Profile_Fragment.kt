package com.example.itplnsehat.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.itplnsehat.R
import com.example.itplnsehat.model.DataHelper
import com.example.itplnsehat.view.Login
import java.text.SimpleDateFormat
import java.util.*

class Profile_Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialized(view)


    }

    @SuppressLint("SimpleDateFormat")
    fun initialized (v : View){
        val db = DataHelper(v.context)
        view?.findViewById<Button>(R.id.btnLogOut)?.setOnClickListener {
            //val intent = Intent(this@Profile_Fragment.requireContext(), Login::class.java)
            val intent = Intent(this@Profile_Fragment.requireContext(), Login::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
        view?.findViewById<Button>(R.id.btn_Website)?.setOnClickListener{
            val m  = Intent(Intent.ACTION_VIEW)
            m.setData(Uri.parse("https://tasyaaku.github.io/ap/"))
            startActivity(m)
        }
        val tvNama = view?.findViewById<TextView>(R.id.text_NamaUser)
        val tvemail = view?.findViewById<TextView>(R.id.text_EmailUser)
        val tvLahir = view?.findViewById<TextView>(R.id.text_BornUser)
        val tvPhone = view?.findViewById<TextView>(R.id.text_PhoneUser)


        val idUser = activity?.intent!!.getStringExtra("iduser").toString()
        val profile = db.profile(idUser.toInt())


        if (tvNama != null) {
            tvNama.text = profile[0]
        }
        if (tvemail != null) {
            tvemail.text = profile[1]
        }
        if (tvPhone != null) {
            tvPhone.text = profile[2]
        }
        if (tvLahir != null) {
            tvLahir.text = profile[3]
        }
    }
}