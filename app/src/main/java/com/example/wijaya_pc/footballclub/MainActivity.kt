package com.example.wijaya_pc.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.wijaya_pc.footballclub.adapter.ClubAdapter
import com.example.wijaya_pc.footballclub.model.Club
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity() {

    private val listClub: MutableList<Club> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadClub()

        verticalLayout {
            lparams(matchParent, matchParent)

            recyclerView {
                layoutManager = LinearLayoutManager(context)
                adapter = ClubAdapter(context, listClub) {
                    startActivity<DetailActivity>(
                        "clubName" to "${it.name}",
                        "clubImage" to it.image,
                        "clubDetail" to "${it.detailClub}"
                    )
                }
            }.lparams(matchParent, matchParent)
        }
    }

    private fun loadClub() {
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val detail = resources.getStringArray(R.array.club_detail)
        listClub.clear()

        for (i in name.indices) {
            listClub.add(Club(name[i], image.getResourceId(i, 0), detail[i]))
        }

        image.recycle()
    }


}
