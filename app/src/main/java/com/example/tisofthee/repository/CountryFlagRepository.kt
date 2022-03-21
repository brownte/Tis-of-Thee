package com.example.tisofthee.repository

import com.apollographql.apollo3.api.ApolloResponse
import com.example.tisofthee.GetCountryAndFlagQuery

interface CountryFlagRepository {
    suspend fun getCountryAndFlagQuery(): ApolloResponse<GetCountryAndFlagQuery.Data>
}