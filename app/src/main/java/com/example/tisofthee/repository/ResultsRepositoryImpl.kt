package com.example.tisofthee.repository

import com.apollographql.apollo3.api.ApolloResponse
import com.example.tisofthee.Apollo
import com.example.tisofthee.GetResultsQuery

class ResultsRepositoryImpl(val apollo: Apollo) : ResultsRepository {
    override suspend fun getResultsQuery(): ApolloResponse<GetResultsQuery.Data> {
        return apollo.getResults()
    }
}