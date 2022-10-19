package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val adapter = PictureAdapter()
    private val pictureList = listOf(
        R.drawable.easy1,
        R.drawable.easy2,
        R.drawable.easy3,
        R.drawable.easy4,
        R.drawable.easy5,
        R.drawable.easy6,
    )
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.apply {
            rvPicture.layoutManager = GridLayoutManager(this@MainActivity, 2)
            rvPicture.adapter = adapter
            btnAddPicture.setOnClickListener {
                if (index > 5) index = 0
                val picture = Picture(pictureList[index], "Picture ${index + 1}")
                adapter.addPicture(picture)
                index++

            }
        }
    }

}
