package com.zubet.formatif1_umahayu_xiipplg3.dbMart

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [Barang::class], version = 1)
abstract class dbBarang : RoomDatabase() {
    abstract fun PTsmksa() :barangDAO

    companion object {
        @Volatile private var instance : dbBarang? =null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            dbBarang::class.java,
            "SMKSA Mart"
        ).build()

    }

}