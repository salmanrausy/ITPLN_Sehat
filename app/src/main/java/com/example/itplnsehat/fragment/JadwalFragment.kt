package com.example.itplnsehat.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.itplnsehat.R
import com.example.itplnsehat.model.DataHelper
import com.example.itplnsehat.model.Jadwal
import kotlinx.android.synthetic.main.fragment_jadwal.*


class JadwalFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view : View =  inflater.inflate(R.layout.fragment_jadwal, container, false)

        return view
    }

    fun initialized (v : View) {
        val db = DataHelper(v.context)

        val data : List<Jadwal> = db.getAllJadwal()

        val tableLayout = view?.findViewById<TableLayout>(com.example.itplnsehat.R.id.tableLayout)

        for (jadwal in data) {
            val tableRow: View = LayoutInflater.from(v.context).inflate(R.layout.table_item, null, false)

            val nama = view?.findViewById<TextView>(R.id.noTable)
            val dokter = view?.findViewById<TextView>(R.id.dokterTable)
            val keterangan = view?.findViewById<TextView>(R.id.keteranganTable)
            val kunjungan = view?.findViewById<TextView>(R.id.kunjunganTable)

            if (nama != null) {
                nama.text = jadwal.id_user.toString()
            }
            if (dokter != null) {
                dokter.text = jadwal.id_dokter.toString()
            }
            if (keterangan != null) {
                keterangan.text = jadwal.keterangan
            }
            if (kunjungan != null) {
                kunjungan.text = jadwal.kunjungan
            }
            if (tableLayout != null) {
                tableLayout.addView(tableRow)
            }
        }


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialized(view)
    }
}