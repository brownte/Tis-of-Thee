package com.example.tisofthee.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.exception.ApolloException
import com.example.tisofthee.GetCountryAndFlagQuery
import com.example.tisofthee.databinding.FragmentMainBinding
import com.example.tisofthee.Apollo

class MainCountryFlagCodeFragment(val apolloClient : ApolloClient,
                                  val countrySelectionListener: CountrySelectionListener) : Fragment() {

    private lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     //   mPresenter = new MainPresenter(this)

        lifecycleScope.launchWhenResumed {
            val response = apolloClient.query(GetCountryAndFlagQuery()).execute()
            Log.d("Country Listing","${response.data}")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenResumed {
            val response = try {
                apolloClient.query(GetCountryAndFlagQuery()).execute()
            } catch (e: ApolloException) {
                Log.d("Country Listing", "Failure", e)
                null
            }

            val countries = response?.data?.countries

            if (countries != null && !response.hasErrors()) {
                val adapter = MainCountryFlagCodeAdapter(countries, countrySelectionListener)
                binding.recyclerViewCountryList.layoutManager = LinearLayoutManager(requireContext())
                binding.recyclerViewCountryList.adapter = adapter

            }
        }
    }

}