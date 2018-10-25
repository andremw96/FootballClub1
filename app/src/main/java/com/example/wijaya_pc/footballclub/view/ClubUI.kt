package com.example.wijaya_pc.footballclub.view

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.wijaya_pc.footballclub.R
import org.jetbrains.anko.*

class ClubUI : AnkoComponent<ViewGroup>{

    companion object {
        const val imageUIid = 1
        const val nameUIid = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui){
        linearLayout {
            orientation = LinearLayout.HORIZONTAL
            padding = dip(16)
            lparams(width = matchParent, height = wrapContent)

            imageView {
                id = imageUIid
                setImageResource(R.drawable.img_default)
            }.lparams(width = dip(50), height = dip(50))

            textView {
                id = nameUIid
                text = "Default FC"
            }.lparams(width = wrapContent, height = wrapContent){
                margin = dip(10)
                gravity = Gravity.CENTER_VERTICAL
            }
        }

    }
}