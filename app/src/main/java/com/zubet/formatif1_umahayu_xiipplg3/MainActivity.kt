package com.zubet.formatif1_umahayu_xiipplg3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.zubet.formatif1_umahayu_xiipplg3.adapter.adapterBarang
import com.zubet.formatif1_umahayu_xiipplg3.databinding.ActivityMainBinding
import com.zubet.formatif1_umahayu_xiipplg3.dbMart.Barang
import com.zubet.formatif1_umahayu_xiipplg3.dbMart.dbBarang
import java.time.temporal.ValueRange

class MainActivity : AppCompatActivity() {

    // 4.pembuatan variabel2 untuk menampilkan data dari database
    private var list = mutableListOf<Barang>()
    private lateinit var adapter: adapterBarang
    private lateinit var database: dbBarang

    // 1. val latenit binding
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // HAPUS "setContentView(R.layout.activity_main)"

        // 2. inflate binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        // 3. setContentView (spy objectnya keluar)
        setContentView(binding.root)

        //5. menampilkan data kedalam rv
        adapter = adapterBarang(list)

        binding.rvList.adapter = adapter
        // layoutManager --> menampilkan data secara horizontal atau vertical
        binding.rvList.layoutManager = LinearLayoutManager(applicationContext, VERTICAL, false)
        binding.rvList.addItemDecoration(DividerItemDecoration(applicationContext, VERTICAL)
        )

        // Memberikan action intent pada tombol fab menu ke halaman
        binding.floatingActionButton.setOnClickListener{
            startActivity(
                Intent(this,input_barang::class.java)
            )
        }

    }

    // Menjalankan funcion getData
    override fun onResume() {
        super.onResume()
        getData()
    }

    // 6. Membuat getData
    fun getData(){
        database = dbBarang.getInstance(applicationContext)
        list.clear()
        list.addAll(database.PTsmksa().getDataBrg())
        adapter.notifyDataSetChanged()
    }
}

