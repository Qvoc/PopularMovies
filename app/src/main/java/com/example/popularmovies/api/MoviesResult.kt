package com.example.popularmovies.api

import com.example.popularmovies.model.Movie
import com.google.gson.annotations.SerializedName

class MoviesResult(
    @SerializedName("results") var resultMovie: List<Movie>
)