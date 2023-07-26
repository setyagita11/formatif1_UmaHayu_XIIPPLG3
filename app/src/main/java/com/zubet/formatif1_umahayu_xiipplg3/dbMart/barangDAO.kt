package com.zubet.formatif1_umahayu_xiipplg3.dbMart

import androidx.room.*

@Dao
interface barangDAO {
    @Insert
    fun insertBrg (barang: Barang)

    @Update
    fun updateBrg (barang: Barang)

    @Delete
    fun deleteBrg (barang: Barang)

    @Query ("SELECT * FROM 'tbBarang'")
    fun getDataBrg() :List<Barang>
}