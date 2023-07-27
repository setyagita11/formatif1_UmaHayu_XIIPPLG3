package com.zubet.formatif1_umahayu_xiipplg3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.zubet.formatif1_umahayu_xiipplg3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 1. val latenit binding
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // HAPUS "setContentView(R.layout.activity_main)"

        // 2. inflate binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        // 3. setContentView (spy objectnya keluar)
        setContentView(binding.root)
        binding.floatingActionButton.setOnClickListener{
            startActivity(
                Intent(this,input_barang::class.java)
            )
        }

    }
}