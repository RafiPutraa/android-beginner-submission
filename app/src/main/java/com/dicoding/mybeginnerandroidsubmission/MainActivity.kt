package com.dicoding.mybeginnerandroidsubmission

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.mybeginnerandroidsubmission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvPlayers: RecyclerView
    private lateinit var btnAbout: ImageButton
    private val list = ArrayList<Player>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        btnAbout = findViewById(R.id.about_page)
        btnAbout.setOnClickListener(this)

        rvPlayers = findViewById(R.id.rv_players)
        rvPlayers.setHasFixedSize(true)
        list.addAll(getListPlayer())
        showRecyclerList()
    }


    private fun getListPlayer(): ArrayList<Player> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataNationality = resources.getStringArray(R.array.data_nationality)
        val dataPosition = resources.getStringArray(R.array.data_position)
        val dataNumber = resources.getIntArray(R.array.data_number)
        val dataDate = resources.getStringArray(R.array.data_date)
        val dataPlace = resources.getStringArray(R.array.data_place)
        val dataHeight = resources.getStringArray(R.array.data_height)
        val dataWeight = resources.getStringArray(R.array.data_weight)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listPlayer = ArrayList<Player>()

        for (i in dataName.indices) {
            val player = Player(dataName[i], dataNationality[i], dataPosition[i], dataNumber[i], dataDate[i], dataPlace[i], dataHeight[i], dataWeight[i], dataDesc[i],  dataPhoto.getResourceId(i, -1))
            listPlayer.add(player)
        }
        return listPlayer
    }

    private fun showRecyclerList() {
        rvPlayers.layoutManager = LinearLayoutManager(this)
        val listPlayerAdapter = ListPlayerAdapter(list)
        rvPlayers.adapter = listPlayerAdapter
    }

    override fun onClick(v: View?) {
        val intent = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(intent)
    }
}