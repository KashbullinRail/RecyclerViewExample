package com.example.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.databinding.ItemPictureBinding

class PictureAdapter : RecyclerView.Adapter<PictureAdapter.PictureHolder>() {

    val pictureList = ArrayList<Picture>()

    class PictureHolder(item: View) : RecyclerView.ViewHolder(item) {

        val binding = ItemPictureBinding.bind(item)
        fun bind(picture: Picture) = with(binding) {
            ivPicture.setImageResource(picture.imageId)
            tvTitle.text = picture.title

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_picture, parent, false)
        return PictureHolder(view)
    }

    override fun onBindViewHolder(holder: PictureHolder, position: Int) {
        holder.bind(pictureList[position])
    }

    override fun getItemCount(): Int {
        return pictureList.size
    }

    fun addPicture(picture: Picture) {
        pictureList.add(picture)
        notifyDataSetChanged()
    }

}