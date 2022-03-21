package com.example.tisofthee

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse

class Apollo {
//TODO: link with rest of project
    val apolloClient = ApolloClient.Builder()
       .serverUrl("https://countries.trevorblades.com/graphql")
       .build()

    suspend fun getCountryAndFlag() : ApolloResponse<GetCountryAndFlagQuery.Data>{
        return apolloClient.query(GetCountryAndFlagQuery()).execute()
    }

    suspend fun getResults() : ApolloResponse<GetResultsQuery.Data>{
        return apolloClient.query(GetResultsQuery("AD")).execute()
    }


}