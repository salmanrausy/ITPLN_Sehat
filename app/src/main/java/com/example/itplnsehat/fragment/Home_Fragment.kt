package com.example.itplnsehat.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.itplnsehat.R
import com.example.itplnsehat.Spesialis_Kardiologi
import com.example.itplnsehat.Spesialis_Pulmonologi
import com.example.itplnsehat.databinding.FragmentHomeBinding
import com.example.itplnsehat.view.BuatJadwal
import kotlinx.android.synthetic.main.fragment_home_.*

class Home_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bind = FragmentHomeBinding.inflate(layoutInflater)

        bind.txtBuatJanji.setOnClickListener{
            val intent = Intent(this@Home_Fragment.requireContext(), BuatJadwal::class.java)
            startActivity(intent)
        }

        bind.txtJantung.setOnClickListener{
            val intent = Intent(this@Home_Fragment.requireContext(), Spesialis_Kardiologi::class.java)
            startActivity(intent)
        }

        bind.txtParu.setOnClickListener{
            val intent = Intent(this@Home_Fragment.requireContext(), Spesialis_Pulmonologi::class.java)
            startActivity(intent)
        }

        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        Txt_Alamat.setOnClickListener{
            val m  = Intent(Intent.ACTION_VIEW)
            m.setData(Uri.parse("https://goo.gl/maps/sQdQ6jjwSBZiM18L6"))
            startActivity(m)
        }
    }
}