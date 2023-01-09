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
import androidx.core.content.res.ResourcesCompat
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
        val typeface = ResourcesCompat.getFont(requireContext(), R.font.didact_gothic)
        var i = 0
        for (jadwal in data) {
            i += 1
            val newRow = TableRow(v.context)
            val tv1 = TextView(v.context)
            val tv2 = TextView(v.context)
            val tv3 = TextView(v.context)
            val tvNomor = TextView(v.context)

            tvNomor.text = i.toString()
            tvNomor.gravity = Gravity.CENTER
            tvNomor.typeface = typeface
            tvNomor.setTextColor(Color.BLACK)
            tvNomor.textAlignment = View.TEXT_ALIGNMENT_CENTER
            tvNomor.textSize= 14F

            tv1.text = jadwal.id_dokter
            tv1.gravity = Gravity.CENTER
            tv1.typeface = typeface
            tv1.setTextColor(Color.BLACK)
            tv1.textAlignment = View.TEXT_ALIGNMENT_CENTER
            tv1.textSize= 14F

            tv2.text = jadwal.keterangan
            tv2.gravity = Gravity.CENTER
            tv2.typeface = typeface
            tv2.layout(0,0,5,0)
            tv2.setTextColor(Color.BLACK)
            tv2.textAlignment = View.TEXT_ALIGNMENT_CENTER
            tv2.textSize= 14F


            tv3.gravity = Gravity.CENTER
            tv3.text = jadwal.kunjungan
            tv3.layout(5,0,5,0)
            tv3.typeface = typeface
            tv3.setTextColor(Color.BLACK)
            tv3.textAlignment = View.TEXT_ALIGNMENT_CENTER
            tv3.textSize= 14F

          newRow.setBackgroundResource(R.color.lightBlue)

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