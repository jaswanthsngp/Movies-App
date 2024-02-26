package com.example.movies.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String = "Title",
    val year: Int = 0,
    val runtime: Int = 0,
    val genre: String = "",
    val actors: String = "",
    val plot: String = "",
    val poster: String = "",
    val rating: Double = 0.0
)
