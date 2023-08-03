package com.zubet.formatif1_umahayu_xiipplg3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.zubet.formatif1_umahayu_xiipplg3.databinding.ActivityInputBarangBinding
import com.zubet.formatif1_umahayu_xiipplg3.dbMart.Barang
import com.zubet.formatif1_umahayu_xiipplg3.dbMart.dbBarang

class input_barang : AppCompatActivity() {

    // Mengenalkan variabel
    private lateinit var binding : ActivityInputBarangBinding
    private lateinit var database : dbBarang

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_barang)

        // Mengambil variabel pada binding
        binding = ActivityInputBarangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengambil variabel pada database
        database = dbBarang.getInstance(applicationContext)

        // Memberikan perintah pada tombol button
        binding.btnSimpanBarang.setOnClickListener{
            if (binding.inputNamaBarang.text.isNotEmpty() &&
                binding.inputHarga.text.isNotEmpty() &&
                binding.inputStok.text.isNotEmpty()) {

                database.PTsmksa().insertBrg(
                    Barang(

                        // Mengambil data dari layout sesuai urutan pada entity barang
                        0, binding.inputNamaBarang.text.toString(),
                        binding.inputHarga.text.toString().toInt(),
                        binding.inputStok.text.toString().toInt()
                    )
                )

                // Menghapus semua text pada form input
                binding.inputNamaBarang.setText("")
                binding.inputHarga.setText("")
                binding.inputStok.setText("")

                // Membuka hal recyclerView stlh tkn tmblDta
                startActivity(
                    Intent(this, MainActivity::class.java
                    )
                )

                // Memberikan if else
            } else {
                Toast.makeText(applicationContext,
                "Silahkan isi semua data terlebih dahulu",
                Toast.LENGTH_SHORT).show()
            }
        }
    }
}