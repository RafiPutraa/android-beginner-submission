package com.dicoding.mybeginnerandroidsubmission

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListPlayerAdapter(private val listPlayer: ArrayList<Player>) : RecyclerView.Adapter<ListPlayerAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvNationality: TextView = itemView.findViewById(R.id.tv_nationality)
        val tvPosition: TextView = itemView.findViewById(R.id.tv_position)
        val tvNumber: TextView = itemView.findViewById(R.id.tv_number)
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_player, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listPlayer.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, nationality, position, number, date, place, height, weight, desc, photo) = listPlayer[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvNationality.text = nationality
        holder.tvPosition.text = position
        holder.tvNumber.text = number.toString()

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_NAME, name)
            intent.putExtra(DetailActivity.EXTRA_NATIONALITY, nationality)
            intent.putExtra(DetailActivity.EXTRA_POSITION, position)
            intent.putExtra(DetailActivity.EXTRA_NUMBER, number)
            intent.putExtra(DetailActivity.EXTRA_DATE, date)
            intent.putExtra(DetailActivity.EXTRA_PLACE, place)
            intent.putExtra(DetailActivity.EXTRA_HEIGHT, height)
            intent.putExtra(DetailActivity.EXTRA_WEIGHT, weight)
            intent.putExtra(DetailActivity.EXTRA_DESC, desc)
            intent.putExtra(DetailActivity.EXTRA_PHOTO, photo)
            holder.itemView.context.startActivity(intent)
        }
    }
}