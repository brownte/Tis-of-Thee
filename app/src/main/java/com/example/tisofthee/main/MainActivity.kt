package com.example.tisofthee.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.tisofthee.R
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getInfoBtn = findViewById<Button>(R.id.btnGetInfo)
        val chipGroup = findViewById<ChipGroup>(R.id.chipGroup)

        getInfoBtn.setOnClickListener {
            chipGroupSelections(chipGroup)
        }

        addCountryFlagFragment()

    }

    private fun addCountryFlagFragment()
    {
        supportFragmentManager.beginTransaction()
            .add(R.id.mainFragment, MainCountryFlagCodeFragment())
            .commit()
    }



    private fun chipGroupSelections(chipGroup : ChipGroup) {
        val selectedChipsList = mutableListOf<String>()

        for (index in 0 until chipGroup.childCount) {
            val chip: Chip = chipGroup.getChildAt(index) as Chip

            chip.setOnCheckedChangeListener { view, isChecked ->
                if (isChecked) {
                    selectedChipsList.add(view.text.toString())
                } else {
                    selectedChipsList.remove(view.text.toString())
                }
            }
        }
    }
}