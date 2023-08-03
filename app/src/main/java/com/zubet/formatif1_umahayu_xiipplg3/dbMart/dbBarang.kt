package com.zubet.formatif1_umahayu_xiipplg3.dbMart

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [Barang::class], version = 1)
abstract class dbBarang : RoomDatabase() {
    abstract fun PTsmksa() :barangDAO

    companion object {
        @Volatile
        private var instance : dbBarang? =null
        private val LOCK = Any()

        fun getInstance(context: Context): dbBarang {
            if (instance == null){
                instance = Room.databaseBuilder(context, dbBarang::class.java, "SMKSA_Mart")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()

            }
            return instance!!
        }

    }

}