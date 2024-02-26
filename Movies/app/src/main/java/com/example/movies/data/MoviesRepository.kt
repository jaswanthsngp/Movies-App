package com.example.movies.data

import kotlinx.coroutines.flow.Flow

interface MoviesRepository {

    fun getAllItems(): Flow<List<Movie>>
    suspend fun insert(movie: Movie)

}