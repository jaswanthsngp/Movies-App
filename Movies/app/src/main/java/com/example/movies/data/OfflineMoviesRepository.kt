package com.example.movies.data

import kotlinx.coroutines.flow.Flow

class OfflineMoviesRepository(private val movieDao: MovieDao): MoviesRepository {
    override fun getAllItems(): Flow<List<Movie>> = movieDao.getAllItems()
    override suspend fun insert(movie: Movie) = movieDao.insert(movie)

}