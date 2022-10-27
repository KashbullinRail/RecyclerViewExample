package com.example.recyclerviewexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Listener {

    lateinit var binding: ActivityMainBinding
    private val adapter = PictureAdapter(this)
    private var editLauncher: ActivityResultLauncher<Intent>? = null

    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                adapter.addPicture(it.data?.getSerializableExtra("picture") as Picture)
            }
        }
    }

    private fun init() {
        binding.apply {
            rvPicture.layoutManager = GridLayoutManager(this@MainActivity, 2)
            rvPicture.adapter = adapter
            btnAddPicture.setOnClickListener {
                editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))

            }
        }
    }

    override fun onClick(picture: Picture) {
       Toast.makeText(this, "нажали на ${picture.title}", Toast.LENGTH_LONG).show()
        startActivity(Intent(this, ContentActivity::class.java).apply {
            putExtra("item", picture)
        })
    }

}
