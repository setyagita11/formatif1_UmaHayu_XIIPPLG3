package com.zubet.formatif1_umahayu_xiipplg3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zubet.formatif1_umahayu_xiipplg3.R
import com.zubet.formatif1_umahayu_xiipplg3.dbMart.Barang

class adapterBarang (val list: List<Barang>) :
        RecyclerView.Adapter<adapterBarang.ViewHolder>(){
    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){ //viewholder --> mnjadikan tmplan

        val namaBarang = itemView.findViewById<TextView>(R.id.tv_nama_barang)
        val hargaBarang = itemView.findViewById<TextView>(R.id.tv_harga_barang)
        val stokBarang = itemView.findViewById<TextView>(R.id.tv_item_stok)
        val edit = itemView.findViewById<ImageButton>(R.id.img_edit)
        val delete = itemView.findViewById<ImageButton>(R.id.img_delete)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder { // Spy bisa mnmplkn
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.barang_adapter, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {// Mnmplkn data
        holder.namaBarang.text = list[position].nama_barang
        holder.hargaBarang.text = list[position].harga.toString()
        holder.stokBarang.text = list[position].stok.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }

}