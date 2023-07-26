package com.zubet.formatif1_umahayu_xiipplg3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Variabel
        val fab = findViewById<View>(R.id.floatingActionButton)
        //Perintah
        fab.setOnClickListener{
            startActivity(Intent(applicationContext, input_barang::class.java))
        }
    }
}