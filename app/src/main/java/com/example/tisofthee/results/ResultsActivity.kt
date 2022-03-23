package com.example.tisofthee.results

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tisofthee.R
import com.example.tisofthee.main.CountryInfo
import com.google.android.material.bottomnavigation.BottomNavigationItemView

class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val bottomNavHomeButton : BottomNavigationItemView = findViewById(R.id.ic_home)
        bottomNavHomeButton.setOnClickListener{
            finish()
        }


        val countryInfo : CountryInfo = intent.getSerializableExtra(COUNTRYINFO) as CountryInfo

        val nameLabel = findViewById<TextView>(R.id.tvName)
        val nameResult = findViewById<TextView>(R.id.tvNameResult)
        val nativeLabel = findViewById<TextView>(R.id.tvNative)
        val nativeResult = findViewById<TextView>(R.id.tvNativeResult)
        val phoneLabel = findViewById<TextView>(R.id.tvPhone)
        val phoneResult = findViewById<TextView>(R.id.tvPhoneResult)
        val continentLabel = findViewById<TextView>(R.id.tvContinent)
        val continentResult = findViewById<TextView>(R.id.tvContinentResult)
        val capitalLabel = findViewById<TextView>(R.id.tvCapital)
        val capitalResult = findViewById<TextView>(R.id.tvCapitalResult)
        val currencyLabel = findViewById<TextView>(R.id.tvCurrency)
        val currencyResult = findViewById<TextView>(R.id.tvCurrencyResult)
        val languagesLabel = findViewById<TextView>(R.id.tvLanguage)
        val languagesResult = findViewById<TextView>(R.id.tvLanguageResult)
        val flagLabel = findViewById<TextView>(R.id.tvFlag)
        val flagResult = findViewById<TextView>(R.id.tvFlagResult)

        if (countryInfo.name != "") {
            nameResult.text = countryInfo.name }
        else {
            nameLabel.visibility = View.GONE
            nameResult.visibility = View.GONE
        }
        if (countryInfo.native != "") {
            nativeResult.text = countryInfo.native }
        else {
            nativeLabel.visibility = View.GONE
            nativeResult.visibility = View.GONE
        }
        if (countryInfo.phone != "") {
            phoneResult.text = countryInfo.phone }
        else {
            phoneLabel.visibility = View.GONE
            phoneResult.visibility = View.GONE
        }
        if (countryInfo.continent != "") {
            continentResult.text = countryInfo.continent }
        else {
            continentLabel.visibility = View.GONE
            continentResult.visibility = View.GONE
        }
        if (countryInfo.capital != "") {
            capitalResult.text = countryInfo.capital }
        else {
            capitalLabel.visibility = View.GONE
            capitalResult.visibility = View.GONE
        }
        if (countryInfo.currency != "") {
            currencyResult.text = countryInfo.currency }
        else {
            currencyLabel.visibility = View.GONE
            currencyResult.visibility = View.GONE
        }
        if (countryInfo.languages != "") {
            languagesResult.text = countryInfo.languages }
        else {
            languagesLabel.visibility = View.GONE
            languagesResult.visibility = View.GONE
        }
        if (countryInfo.emoji != "") {
            flagResult.text = countryInfo.emoji }
        else {
            flagLabel.visibility = View.GONE
            flagResult.visibility = View.GONE
        }

    }

    companion object {
        const val COUNTRYINFO = "CountyInfo"
    }




}