package com.example.itplnsehat.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.itplnsehat.R
import com.example.itplnsehat.model.DataHelper
import com.example.itplnsehat.view.Beranda
import com.example.itplnsehat.view.EditProfile
import com.example.itplnsehat.view.Login
import java.text.SimpleDateFormat
import java.util.*

class Profile_Fragment : Fragment() {
    val idUser = activity?.intent!!.getStringExtra("iduser").toString()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_profile_, container, false)
        val view: View = inflater.inflate(R.layout.fragment_profile_, container, false)
        val btn: Button = view.findViewById(R.id.btn_EditProfile)
        btn.setOnClickListener{
            val bundle = Bundle()
            val intent = Intent(activity, EditProfile::class.java)
            bundle.putString("idUser", idUser)
            intent.putExtras(bundle)
            startActivity(intent)
        }


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialized(view)

    }
    fun initialized (v : View){
        val db = DataHelper(v.context)

        val tvNama = view?.findViewById<TextView>(R.id.text_NamaUser)
        val tvemail = view?.findViewById<TextView>(R.id.text_EmailUser)
        val tvLahir = view?.findViewById<TextView>(R.id.text_BornUser)
        val tvPhone = view?.findViewById<TextView>(R.id.text_PhoneUser)

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