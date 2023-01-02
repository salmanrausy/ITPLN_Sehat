package com.example.itplnsehat.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.itplnsehat.R
import com.example.itplnsehat.databinding.FragmentHomeBinding
import com.example.itplnsehat.model.DataHelper
import com.example.itplnsehat.view.EditProfile
import com.example.itplnsehat.view.Login
import kotlinx.android.synthetic.main.fragment_profile_.*
import java.text.SimpleDateFormat
import java.util.*

class Profile_Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val bind = FragmentHomeBinding.inflate(layoutInflater)

        btn_EditProfile.setOnClickListener{
            val intent = Intent (this@Profile_Fragment.requireContext(),EditProfile::class.java)
            startActivity(intent)
        }

        btn_LogOut.setOnClickListener{
            val intent = Intent (this@Profile_Fragment.requireContext(),Login::class.java)
            startActivity(intent)
        }

        return bind.root
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


        val idUser = activity?.intent!!.getStringExtra("iduser").toString()
        val profile = db.profile(idUser.toInt())

        val parser = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.US)
        val date = formatter.format(parser.parse(profile[3]))

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
            tvLahir.text = date
        }
    }
}