package com.example.itplnsehat

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter

class ImageSliderAdapter(var dataSlider : ArrayList<Int>, var context : Activity?) : PagerAdapter(){

    lateinit var layoutInflater : LayoutInflater

    override fun getCount(): Int {
        return dataSlider.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.item_slide, container,false)

        val imgViewSlider : ImageView
        imgViewSlider = view.findViewById(R.id.iv_slider)

        imgViewSlider.setImageResource(dataSlider[position])
        container.addView(view, 0)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)

        container.removeView(`object` as View)
    }
}