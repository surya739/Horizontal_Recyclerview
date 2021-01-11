package com.example.recycleview1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    private val mNames = ArrayList<String>()
    private val mImageUrls = ArrayList<String>()
    private var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: started.")
        initimageBitmap()
        recyclerView = findViewById(R.id.recycler_view)
    }

    fun initimageBitmap() {
        Log.d(TAG, "initimageBitmap: preparing bitmaps.")
        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg")
        mNames.add("Trondheim")
        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg")
        mNames.add("Portugal")
        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg")
        mNames.add("Rocky Mountain National Park")
        mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg")
        mNames.add("Mahahual")
        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg")
        mNames.add("Frozen Lake")
        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg")
        mNames.add("White Sands Desert")
        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg")
        mNames.add("Austrailia")
        mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg")
        mNames.add("Washington")
        initRecyclerView()
    }

    private fun initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview.")
        val LayoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = RecycleViewAdapter(this, mNames, mImageUrls)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LayoutManager
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}