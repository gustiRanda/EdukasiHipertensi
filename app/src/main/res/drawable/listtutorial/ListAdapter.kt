package com.gmind.listtutorial

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListAdapter(private val listSenjata: ArrayList<Senjata>) :  RecyclerView.Adapter<ListAdapter.ListViewHolder>(){


    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivAvatar: ImageView = itemView.findViewById(R.id.iv_gambar)
        var tvNama: TextView = itemView.findViewById(R.id.tv_nama)
        var tvDeskripsi: TextView = itemView.findViewById(R.id.tv_deskripsi)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val senjata = listSenjata[position]
        Glide.with(holder.itemView.context)
            .load(senjata.photo)
            .into(holder.ivAvatar)

        holder.tvNama.text = senjata.nama
        holder.tvDeskripsi.text = senjata.desktripsi

        holder.itemView.setOnClickListener (object : View.OnClickListener{
            override fun onClick(view: View) {
                onItemClickCallback.onItemClicked(listSenjata[holder.adapterPosition])
                val intent = Intent(view.context.applicationContext, DetailActivity::class.java)

                intent.putExtra(DetailActivity.NAMA, senjata.nama)
                intent.putExtra(DetailActivity.DESKRIPSI, senjata.desktripsi)
                intent.putExtra(DetailActivity.PHOTO, senjata.photo)
                view.context.startActivity(intent)
            }

        })
    }

    override fun getItemCount(): Int {
        return listSenjata.size
    }

    interface OnItemClickCallback{
        fun onItemClicked(senjata: Senjata)
    }
}