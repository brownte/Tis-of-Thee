package com.example.tisofthee.repository

import com.apollographql.apollo3.api.ApolloResponse
import com.example.tisofthee.GetResultsQuery

interface ResultsRepository {
    suspend fun getResultsQuery(): ApolloResponse<GetResultsQuery.Data>
}