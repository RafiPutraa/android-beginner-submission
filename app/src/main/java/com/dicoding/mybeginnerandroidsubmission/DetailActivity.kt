package com.dicoding.mybeginnerandroidsubmission

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_NATIONALITY = "extra_nationality"
        const val EXTRA_POSITION = "extra_position"
        const val EXTRA_NUMBER = "extra_number"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_DATE = "extra_data"
        const val EXTRA_PLACE = "extra_place"
        const val EXTRA_HEIGHT = "extra_height"
        const val EXTRA_WEIGHT = "extra_weight"
        const val EXTRA_PHOTO = "extra_photo"

        private lateinit var btnBack: ImageButton
        private lateinit var btnShare: ImageButton

        private lateinit var imgPhoto: ImageView
        private lateinit var tvName: TextView
        private lateinit var tvNationality: TextView
        private lateinit var tvPosition: TextView
        private lateinit var tvNumber: TextView
        private lateinit var tvDate: TextView
        private lateinit var tvPlace: TextView
        private lateinit var tvHeight: TextView
        private lateinit var tvWeight: TextView
        private lateinit var tvDesc: TextView
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        btnBack = findViewById(R.id.btn_back)
        btnShare = findViewById(R.id.action_share)
        imgPhoto = findViewById(R.id.img_item_photo)
        tvName = findViewById(R.id.tv_item_name)
        tvNationality = findViewById(R.id.tv_nationality)
        tvPosition = findViewById(R.id.tv_position)
        tvNumber = findViewById(R.id.tv_number)
        tvDate = findViewById(R.id.tv_date)
        tvPlace = findViewById(R.id.tv_place)
        tvHeight = findViewById(R.id.tv_height)
        tvWeight = findViewById(R.id.tv_weight)
        tvDesc = findViewById(R.id.tv_item_desc)

        val name = intent.getStringExtra(EXTRA_NAME)
        val nationality = intent.getStringExtra(EXTRA_NATIONALITY)
        val position = intent.getStringExtra(EXTRA_POSITION)
        val number = intent.getIntExtra(EXTRA_NUMBER,0)
        val date = intent.getStringExtra(EXTRA_DATE)
        val place = intent.getStringExtra(EXTRA_PLACE)
        val height = intent.getStringExtra(EXTRA_HEIGHT)
        val weight = intent.getStringExtra(EXTRA_WEIGHT)
        val desc = intent.getStringExtra(EXTRA_DESC)
        val photo = intent.getIntExtra(EXTRA_PHOTO, -1)

        tvName.text = name
        tvNationality.text = nationality
        tvPosition.text = position
        tvNumber.text = number.toString()
        tvDate.text = date
        tvPlace.text = place
        tvHeight.text = height
        tvWeight.text = weight
        tvDesc.text = desc
        imgPhoto.setImageResource(photo)

        btnBack.setOnClickListener(this)
        btnShare.setOnClickListener{sharePlayerInfo()}
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_back -> {
                finish()
            }
        }
    }

    private fun sharePlayerInfo(){
        val playerName = tvName.text.toString()
        val playerDesc = tvDesc.text.toString()
        val shareText = "Check out this player: $playerName\nDescription: $playerDesc"

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, shareText)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}