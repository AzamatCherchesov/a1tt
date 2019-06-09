package com.a1tt.notebook.tutorial

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.a1tt.notebook.MainActivity
import com.a1tt.notebook.R
import com.a1tt.notebook.customView.PageIndicatorView
import com.a1tt.notebook.customView.animation.type.AnimationType
import java.util.ArrayList

class TutorialActivity: AppCompatActivity() {

    var pager: ViewPager? = null
    var nextButton: ImageButton? = null
    var prevButton: ImageButton? = null
    var pageIndicatorView: PageIndicatorView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tutorial_main)

        pager = findViewById(R.id.viewPager)
        nextButton = findViewById(R.id.next_button)
        prevButton = findViewById(R.id.prev_button)

        initViews()
        nextButton?.setOnClickListener {
            val currentNumber = pager!!.currentItem
            pager!!.adapter?.let {
                if (currentNumber < it.count - 1) {
                    pager!!.setCurrentItem(pager!!.currentItem + 1, true)
                } else if (currentNumber == it.count - 1) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
        prevButton?.setOnClickListener {
            val currentNumber = pager!!.currentItem
            if (currentNumber > 0) {
                pager!!.setCurrentItem(pager!!.currentItem - 1, true)
            }
        }

        pageIndicatorView = findViewById(R.id.pageIndicatorView)
        pageIndicatorView?.setFadeOnIdle(true)
        pageIndicatorView?.setInteractiveAnimation(true)
        pageIndicatorView?.setAnimationType(AnimationType.SCALE)
    }

    private fun initViews() {
        val adapter = TutorialAdapter()
        adapter.setData(createPageList())
        pager?.adapter = adapter
    }

    private fun createPageList(): List<View> {
        val pageList = ArrayList<View>()
        pageList.add(createPageView(R.color.google_red))
        pageList.add(createPageView(R.color.google_blue))
        pageList.add(createPageView(R.color.google_yellow))
        pageList.add(createPageView(R.color.google_green))

        return pageList
    }

    private fun createPageView(color: Int): View {
        val view = View(this)
        view.setBackgroundColor(resources.getColor(color))

        return view
    }

}