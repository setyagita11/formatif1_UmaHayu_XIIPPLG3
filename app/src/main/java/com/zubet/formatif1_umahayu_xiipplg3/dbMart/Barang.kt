package com.zubet.formatif1_umahayu_xiipplg3.dbMart

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbBarang")
data class Barang(
    @PrimaryKey (autoGenerate = false)
    @ColumnInfo(name = "id barang")
    val id_barang : Int,
    @ColumnInfo(name = "nama barang")
    val nama_barang : String,
    @ColumnInfo(name = "harga")
    val harga : Int,
    @ColumnInfo(name = "stok")
    val stok : Int
)
