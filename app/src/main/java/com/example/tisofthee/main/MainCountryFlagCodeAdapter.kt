package com.example.tisofthee.main


import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tisofthee.GetCountryAndFlagQuery
import com.example.tisofthee.databinding.MainRecyclerViewItemsBinding

class MainCountryFlagCodeAdapter(private val countries: List<GetCountryAndFlagQuery.Country>) : RecyclerView.Adapter<MainCountryFlagCodeAdapter.ViewHolder>() {

    class ViewHolder(val binding: MainRecyclerViewItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        //TODO: try calling card color changer in here?

    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MainRecyclerViewItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countries[position]
        val absolutePosition = holder.absoluteAdapterPosition

        holder.binding.tvFlag.text = country.emoji
        holder.binding.tvCountry.text = country.name
        holder.binding.tvCountryCode.text = country.code

        //TODO: need to somehow code this to allow only one country/one recycler view (use absolute position) to be selected & color coded
        holder.binding.cardContainer.setOnClickListener(){
                holder.binding.cardContainer.setCardBackgroundColor(Color.parseColor("#FF018786"))
        }

    }


}