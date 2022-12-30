package com.example.itplnsehat

import android.media.Image
import android.os.Build
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.itplnsehat.databinding.FragmentHomeBinding


class Home_Fragment : Fragment() {
    private var binding : FragmentHomeBinding? = null
    lateinit var vpSlider : ViewPager
    lateinit var rvDokter : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_, container, false)
        vpSlider = view.findViewById(R.id.view_pager)

        val arraySlider = ArrayList<Int>()

        arraySlider.add(R.drawable.dokter_1)
        arraySlider.add(R.drawable.dokter_2)
        arraySlider.add(R.drawable.dokter_3)
        arraySlider.add(R.drawable.dokter_4)
        arraySlider.add(R.drawable.dokter_5)
        arraySlider.add(R.drawable.dokter_6)

        val sliderAdapter = ImageSliderAdapter(arraySlider, activity)
        vpSlider.adapter = sliderAdapter

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}