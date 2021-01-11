package com.example.recycleview1

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import java.util.*

class RecycleViewAdapter(context: Context, mimagename: ArrayList<String>, image: ArrayList<String>) : RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>() {
    private var mimagename = ArrayList<String>()
    private var image = ArrayList<String>()
    private val context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_listitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: called.")
        Glide.with(context)
                .asBitmap()
                .load(image[position])
                .into(holder.image)
        holder.imagename.text = mimagename[position]
        holder.parentlayout.setOnClickListener { Log.d(TAG, "onClick: clicked on:" + mimagename[position]) }
    }

    override fun getItemCount(): Int {
        return mimagename.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: CircleImageView
        var imagename: TextView
        var parentlayout: RelativeLayout

        init {
            image = itemView.findViewById(R.id.image)
            imagename = itemView.findViewById(R.id.image_name)
            parentlayout = itemView.findViewById(R.id.parent_layout)
        }
    }

    companion object {
        private const val TAG = "RecycleViewAdapter"
    }

    init {
        this.mimagename = mimagename
        this.image = image
        this.context = context
    }
}