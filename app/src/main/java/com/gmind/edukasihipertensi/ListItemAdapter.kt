package com.gmind.edukasihipertensi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gmind.edukasihipertensi.databinding.ListItemBinding

@Suppress("DEPRECATION")
class ListItemAdapter(private val listItems: ArrayList<Hipertensi>): RecyclerView.Adapter<ListItemAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }


    inner class ListViewHolder(itemView: ListItemBinding) : RecyclerView.ViewHolder(itemView.root){
        private val binding = itemView
        fun bind(data: Hipertensi){
            with(binding){

                Glide.with(itemView)
                    .load(data.contentIcon)
                    .into(ivFoto)

                tvJudul.text = data.contentJudul
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listItems[position])

        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listItems[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listItems.size

    interface OnItemClickCallback{
        fun onItemClicked(hipertensi: Hipertensi)
    }
}