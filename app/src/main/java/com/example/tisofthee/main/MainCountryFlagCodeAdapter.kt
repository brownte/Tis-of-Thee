package com.example.tisofthee.main



import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tisofthee.GetCountryAndFlagQuery
import com.example.tisofthee.databinding.MainRecyclerViewItemsBinding



class MainCountryFlagCodeAdapter(
    private val countries: List<GetCountryAndFlagQuery.Country>,
    private val countrySelectionListener: CountrySelectionListener):
    RecyclerView.Adapter<MainCountryFlagCodeAdapter.ViewHolder>() {

    var selectedCountry : Int = -1

    class ViewHolder(val binding: MainRecyclerViewItemsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MainRecyclerViewItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countries[position]

        holder.binding.tvFlag.text = country.emoji
        holder.binding.tvCountry.text = country.name
        holder.binding.tvCountryCode.text = country.code


        if (position == selectedCountry) {
            holder.binding.cardContainer.setCardBackgroundColor(Color.parseColor("#FF018786"))
        } else {
            holder.binding.cardContainer.setCardBackgroundColor(Color.parseColor("#FFFFFFFF"))
        }

        holder.binding.cardContainer.setOnClickListener {
            selectedCountry = position
            countrySelectionListener.selectedCountryCode(country.code)
                holder.binding.cardContainer.setCardBackgroundColor(Color.parseColor("#FF018786"))
        }

    }


}

