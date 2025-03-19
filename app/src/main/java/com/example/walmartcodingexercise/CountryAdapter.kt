package com.example.walmartcodingexercise

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(private val countryList: List<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_item, parent, false)
        return CountryViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countryList[position]
        holder.nameTextView.text = "Name: ${country.name}"
        holder.regionTextView.text = "Region: ${country.region}"
        holder.codeTextView.text = "Code: ${country.code}"
        holder.capitalTextView.text = "Capital: ${country.capital}"

    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val regionTextView: TextView = itemView.findViewById(R.id.regionTextView)
        val codeTextView: TextView = itemView.findViewById(R.id.codeTextView)
        val capitalTextView: TextView = itemView.findViewById(R.id.capitalTextView)
    }
}