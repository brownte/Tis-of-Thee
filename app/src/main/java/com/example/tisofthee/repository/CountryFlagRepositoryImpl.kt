package com.example.tisofthee.repository

import com.apollographql.apollo3.api.ApolloResponse
import com.example.tisofthee.Apollo
import com.example.tisofthee.GetCountryAndFlagQuery

//TODO: get this working
class CountryFlagRepositoryImpl(val apollo: Apollo) : CountryFlagRepository {

    override suspend fun getCountryAndFlagQuery(): ApolloResponse<GetCountryAndFlagQuery.Data> {
       return apollo.getCountryAndFlag()
    }
}