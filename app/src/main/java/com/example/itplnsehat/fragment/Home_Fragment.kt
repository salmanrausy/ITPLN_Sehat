package com.example.itplnsehat.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.itplnsehat.R
import kotlinx.android.synthetic.main.fragment_home_.*

class Home_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_, container, false)

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