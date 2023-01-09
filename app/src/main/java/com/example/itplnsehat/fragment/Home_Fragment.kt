package com.example.itplnsehat.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.itplnsehat.R
import com.example.itplnsehat.view.Spesialis_Kardiologi
import com.example.itplnsehat.view.Spesialis_Pulmonologi
import com.example.itplnsehat.view.BuatJadwal

class Home_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialized()
    }

    fun initialized() {
        val idUser = activity?.intent!!.getStringExtra("iduser").toString()
        view?.findViewById<TextView>(R.id.txt_BuatJanji)?.setOnClickListener {
            val bundle = Bundle()
            val intent = Intent(this@Home_Fragment.requireContext(), BuatJadwal::class.java)
            bundle.putString("iduser", idUser)
            intent.putExtras(bundle)
            startActivity(intent)
        }

        view?.findViewById<TextView>(R.id.txtJantung)?.setOnClickListener {
            val intent = Intent(this@Home_Fragment.requireContext(), Spesialis_Kardiologi::class.java)
            startActivity(intent)
        }

        view?.findViewById<TextView>(R.id.txtParu)?.setOnClickListener {
            val intent = Intent(this@Home_Fragment.requireContext(), Spesialis_Pulmonologi::class.java)
            startActivity(intent)
        }

        view?.findViewById<TextView>(R.id.Txt_Alamat)?.setOnClickListener{
            val m  = Intent(Intent.ACTION_VIEW)
            m.setData(Uri.parse("https://goo.gl/maps/sQdQ6jjwSBZiM18L6"))
            startActivity(m)
        }
    }
}