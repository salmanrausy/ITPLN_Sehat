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
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.itplnsehat.databinding.ActivityMainBinding


class Home_Fragment : Fragment() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter: ImageSliderAdapter
    private val list = ArrayList<ImageData>()
    private lateinit var dots : ArrayList<TextView>

    override fun onCreate(
//                            inflater: LayoutInflater, container: ViewGroup?
                            savedInstanceState: Bundle?) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list.add(
            ImageData(
                //image = dokter_1.jpg
                "https://drive.google.com/file/d/1Gg3y3LpmemKXOCyRyxdqpxMKpI4yCyDE/view?usp=share_link"
            )
        )

        list.add(
            ImageData(
                //image = dokter_2.jpg
                "https://drive.google.com/file/d/18OjFu39DCJGn36FQ2vfeeJbEq1vRPLi2/view?usp=share_link"
            )
        )

        list.add(
            ImageData(
                //image = dokter_3.jpg
                "https://drive.google.com/file/d/1KBKLTpGOGx7GEFH5GFlu5vdfKbaqaqBR/view?usp=share_link"
            )
        )

        list.add(
            ImageData(
                //image = dokter_4.jpg
                "https://drive.google.com/file/d/10ObRiS7b_nYalBjnm9ErMGw_zE7A_rFI/view?usp=share_link"
            )
        )

        list.add(
            ImageData(
                //image = dokter_5.jpg
                "https://drive.google.com/file/d/1mr5RPH_xNqmI7-gwBMhwkB04tCRSaiwZ/view?usp=share_link"
            )
        )

        list.add(
            ImageData(
                //image = dokter_6.jpg
                "https://drive.google.com/file/d/1gCFeDE-I6H93zyOqDg-1SJYCjWpVLj8g/view?usp=share_link"
            )
        )

        adapter = ImageSliderAdapter(list)
        binding.viewPager.adapter = adapter
        dots = ArrayList()
        setIndicator()

        binding.viewPager.registerOnPageChangeCallback(object  : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                selectedDot(position)
                super.onPageSelected(position)
            }
        })
    }

    private fun selectedDot(position: Int) {
        for(i in 0 until list.size){
            if (i == position){
                dots[i].setTextColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_default_color_primary))
            }
            else{
                dots[i].setTextColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_default_color_secondary))
            }
        }
    }

    private fun setIndicator() {
        for(i in 0 until list.size){
            dots.add(TextView(this))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                dots[i].text = Html.fromHtml("&#9679", Html.FROM_HTML_MODE_LEGACY).toString()
            }
            else{
                dots[i].text = Html.fromHtml("&#9679")
            }
            dots[i].textSize = 18f
            binding.dotsIndicator.addView(dots[i])
        }
    }

}