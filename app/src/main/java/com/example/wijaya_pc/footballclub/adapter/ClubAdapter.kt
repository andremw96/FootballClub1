package com.example.wijaya_pc.footballclub.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.wijaya_pc.footballclub.model.Club
import com.example.wijaya_pc.footballclub.view.ClubUI
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext

class ClubAdapter(private val context: Context, private val clubs: List<Club>, private val listener: (Club) -> Unit) :
    RecyclerView.Adapter<ClubAdapter.ClubViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder {
        return ClubViewHolder(ClubUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        holder.bindItem(clubs[position], listener)
    }

    override fun getItemCount(): Int = clubs.size

    class ClubViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        private var clubImageView: ImageView = itemView.findViewById(ClubUI.imageUIid)
        private var clubTextView: TextView = itemView.findViewById(ClubUI.nameUIid)


        fun bindItem(clubs: Club, listener: (Club) -> Unit) {
            clubTextView.text = clubs.name
            Glide.with(itemView.context).load(clubs.image).into(clubImageView)
            itemView.setOnClickListener {
                listener(clubs)
            }
        }
    }
}