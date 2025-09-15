package com.example.walmartcountriesassessment.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.walmartcountriesassessment.databinding.ItemCountryBinding
import data.model.CountryDetails
import timber.log.Timber


class CountriesAdapater(private var items: List<CountryDetails> = emptyList()) :
    RecyclerView.Adapter<CountriesAdapater.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun updateItems(newItems: List<CountryDetails>) {
        items = newItems
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CountryDetails) {
            binding.title.text = "${item.name ?: "Unknown"}, ${item.region}"
            binding.code.text = item.code ?: ""
            binding.capital.text = item.capital ?: ""
            binding.root.setOnClickListener {
                Timber.d("Clicked on ${item.name}")
            }
        }
    }
}