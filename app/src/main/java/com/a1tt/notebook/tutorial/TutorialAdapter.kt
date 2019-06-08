package com.a1tt.notebook.tutorial

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class TutorialAdapter: PagerAdapter() {

    private val viewList = mutableListOf<View>()

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val view = viewList[position]
        collection.addView(view)
        return view
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return viewList.size
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    fun setData(list: List<View>?) {
        this.viewList.clear()
        if (list != null && list.isNotEmpty()) {
            this.viewList.addAll(list)
        }

        notifyDataSetChanged()
    }
}