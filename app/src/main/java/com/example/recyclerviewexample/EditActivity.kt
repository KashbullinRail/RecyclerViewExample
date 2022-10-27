package com.example.recyclerviewexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.recyclerviewexample.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    lateinit var binding: ActivityEditBinding

    private var indexImage = R.drawable.easy3
    private var indexId = 0

    private val imageList = listOf(
        R.drawable.easy1,
        R.drawable.easy2,
        R.drawable.easy3,
        R.drawable.easy4,
        R.drawable.easy5,
        R.drawable.easy6,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButton()
    }

    private fun initButton() = with(binding) {
        btnNext.setOnClickListener {
            indexImage++
            if (indexImage > imageList.size - 1) indexImage = 0
            Log.d("MyLOG", "index $indexImage")
            indexId = imageList[indexImage]
            ivEditPicture.setImageResource(indexId)
        }

        btnDone.setOnClickListener {
            val picture = Picture(indexId, etTitle.text.toString(), etTitle2.text.toString())
            val editIntent = Intent().apply {
                putExtra("picture", picture)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }

}