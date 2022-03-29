package com.example.tisofthee.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.exception.ApolloException
import com.example.tisofthee.GetResultsQuery
import com.example.tisofthee.R
import com.example.tisofthee.results.ResultsActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup



class MainActivity : AppCompatActivity(), CountrySelectionListener {
    private var selectedCountryCode : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getInfoBtn = findViewById<Button>(R.id.btnGetInfo)
        val chipGroup = findViewById<ChipGroup>(R.id.chipGroup)

        getInfoBtn.setOnClickListener {
            val selectedChips = chipGroupSelections(chipGroup)
            requestCountryResults(selectedChips)
        }

        addCountryFlagFragment()

    }

    private fun addCountryFlagFragment()
    {
        supportFragmentManager.beginTransaction()
            .add(R.id.mainFragment, MainCountryFlagCodeFragment(apolloClient, this))
            .commit()
    }

    private val apolloClient = ApolloClient.Builder()
        .serverUrl("https://countries.trevorblades.com/graphql")
        .build()


    private fun chipGroupSelections(chipGroup : ChipGroup) : MutableList<String> {
        val selectedChipsList = mutableListOf<String>()

        for (index in 0 until chipGroup.childCount) {
            val chip: Chip = chipGroup.getChildAt(index) as Chip
            if (chip.isChecked) {
                selectedChipsList.add(chip.text.toString())
            }
        }
        return selectedChipsList
    }

    private fun requestCountryResults(selectedChips : MutableList<String>) {
        lifecycleScope.launchWhenResumed {
            val response = try {
                apolloClient.query(GetResultsQuery(selectedCountryCode)).execute()
            } catch (e: ApolloException) {
                Log.d("Results Listing", "Failure", e)
                null
            }

            val country = response?.data?.country

            if (country != null && !response.hasErrors()) {
                val countryInfo = CountryInfo()

                if (selectedChips.contains("name")) {
                    countryInfo.name = country.name
                    }
                if (selectedChips.contains("native")) {
                    countryInfo.native = country.native
                }
                if (selectedChips.contains("phone")) {
                    countryInfo.phone = country.phone
                }
                if (selectedChips.contains("continent")) {
                    countryInfo.continent = country.continent.name
                }
                if (selectedChips.contains("capital")) {
                    countryInfo.capital = country.capital ?: ""
                }
                if (selectedChips.contains("currency")) {
                    countryInfo.currency = country.currency ?: ""
                }
                if (selectedChips.contains("languages")) {
                    countryInfo.languages = country.languages[0].name ?: ""
                }
                if (selectedChips.contains("flag")) {
                    countryInfo.emoji = country.emoji
                }

                initializeResultsActivity(countryInfo)
            }
        }
    }

    fun initializeResultsActivity(countryInfo : CountryInfo) {
        val intent = Intent(this, ResultsActivity::class.java)
        intent.putExtra(ResultsActivity.COUNTRYINFO, countryInfo)
        startActivity(intent)
    }

    override fun selectedCountryCode(_selectedCountryCode : String) {
        selectedCountryCode = _selectedCountryCode
    }


}