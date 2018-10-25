package com.example.wijaya_pc.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    private var clubName: String = ""
    private var clubImage: Int = 0
    private var clubDetail: String = ""


    private lateinit var clubImageViewDet: ImageView
    private lateinit var clubNameViewDet: TextView
    private lateinit var clubDetailViewDet: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        verticalLayout {
            padding = dip(16)

            clubImageViewDet = imageView {
                setImageResource(R.drawable.img_default)
            }.lparams(width = dip(100), height = dip(100)) {
                margin = dip(10)
                gravity = Gravity.CENTER
            }

            clubNameViewDet = textView {
                text = resources.getString(R.string.clubNameDefault)
            }.lparams(width = wrapContent, height = wrapContent) {
                margin = dip(10)
                gravity = Gravity.CENTER
            }

            clubDetailViewDet = textView {
                text = resources.getString(R.string.clubDetailDefault)
            }.lparams(width = wrapContent, height = wrapContent) {
                margin = dip(10)
                gravity = Gravity.CENTER
            }
        }

        val intent = intent
        clubName = intent.getStringExtra("clubName")
        clubImage = intent.getIntExtra("clubImage", R.drawable.img_default)
        clubDetail = intent.getStringExtra("clubDetail")

        Log.d("clubimage", "$clubImage")

        clubNameViewDet.text = clubName
        Glide.with(clubImageViewDet).load(clubImage).into(clubImageViewDet)
        clubDetailViewDet.text = clubDetail
    }
}
