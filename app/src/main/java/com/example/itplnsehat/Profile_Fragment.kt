package com.example.itplnsehat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class Profile_Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialized(view)
    }
    fun initialized (v : View){
        val db = DataHelper(v.context)

        val edtNama = view?.findViewById<TextView>(R.id.text_NamaUser)
        val edtemail = view?.findViewById<TextView>(R.id.text_EmailUser)
        val edtLahir = view?.findViewById<TextView>(R.id.text_BornUser)
        val edtPhone = view?.findViewById<TextView>(R.id.text_PhoneUser)


        val idUser = activity?.intent!!.getStringExtra("iduser").toString()
        val profile = db.profile(idUser.toString().toInt())

        val parser = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.US)
        val date = formatter.format(parser.parse(profile[3]))

        if (edtNama != null) {
            edtNama.text = profile[0]
        }
        if (edtemail != null) {
            edtemail.text = profile[1]
        }
        if (edtPhone != null) {
            edtPhone.text = profile[2]
        }
        if (edtLahir != null) {
            edtLahir.text = date
        }
    }
}