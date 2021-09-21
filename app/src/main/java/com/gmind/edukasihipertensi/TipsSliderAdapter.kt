package com.gmind.edukasihipertensi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gmind.edukasihipertensi.databinding.TipsSlideBinding

class TipsSliderAdapter(private val items: ArrayList<TipsKesehatan>) : RecyclerView.Adapter<TipsSliderAdapter.TipsSlideViewHolder>() {

    inner class TipsSlideViewHolder(itemView : TipsSlideBinding) : RecyclerView.ViewHolder(itemView.root){
        private val binding = itemView
        fun bind(data: TipsKesehatan){
            with(binding){
                Glide.with(itemView)
                    .load(data.foto)
                    .into(ivSlider)

                tvSlider.text = data.judul
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipsSlideViewHolder {
        return TipsSlideViewHolder(TipsSlideBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TipsSlideViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}