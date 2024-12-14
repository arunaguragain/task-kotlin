package com.example.task.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task.R
import de.hdodenhof.circleimageview.CircleImageView

class BirdsAdapter (
    val context: Context,
    val imageList: ArrayList<Int>,
    val BirdsTitle: ArrayList<String>,
    val BirdsDesc: ArrayList<String>,
) : RecyclerView.Adapter<BirdsAdapter.BirdsViewHolder>() {
    class BirdsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: CircleImageView = itemView.findViewById(R.id.profile)
        var title: TextView = itemView.findViewById(R.id.birdName)
        var desc: TextView = itemView.findViewById(R.id.birdDescription)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BirdsViewHolder {
        val itemView: View = LayoutInflater.from(context).inflate(R.layout.bird_picture, parent, false)
        return BirdsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: BirdsViewHolder, position: Int) {
        holder.title.text = BirdsTitle[position] //for loop jasari kaam garxa
        holder.desc.text = BirdsDesc[position]
        holder.image.setImageResource(imageList[position])
    }


}