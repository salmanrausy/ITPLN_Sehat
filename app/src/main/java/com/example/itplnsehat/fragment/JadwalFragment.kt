package com.example.itplnsehat.fragment


import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.itplnsehat.R
import com.example.itplnsehat.model.DataHelper
import com.example.itplnsehat.model.Jadwal


class JadwalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jadwal, container, false)
    }

    private fun initialized (v : View) {
        val idUser = activity?.intent!!.getStringExtra("iduser").toString().toInt()
        val db = DataHelper(v.context)

        val data : List<Jadwal> = db.getJadwal(idUser)

        var i = 0
        for (jadwal in data) {
            i += 1
            val newRow = TableRow(v.context)
            val tv1 = TextView(v.context)
            val tv2 = TextView(v.context)
            val tv3 = TextView(v.context)
            val tvNomor = TextView(v.context)

            tvNomor.text = i.toString()
            tvNomor.setTextColor(Color.WHITE)
            tvNomor.gravity = Gravity.CENTER


            tv1.text = jadwal.id_dokter.toString()
            tv1.setTextColor(Color.WHITE)
            tv1.gravity = Gravity.CENTER

            tv2.text = jadwal.keterangan
            tv2.setTextColor(Color.WHITE)
            tv2.gravity = Gravity.CENTER

            tv3.text = jadwal.kunjungan
            tv3.setTextColor(Color.WHITE)
            tv3.gravity = Gravity.CENTER

            newRow.addView(tvNomor)
            newRow.addView(tv1)
            newRow.addView(tv2)
            newRow.addView(tv3)

            view?.findViewById<TableLayout>(R.id.tableLayout)?.addView(newRow)

        }


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialized(view)
    }
}