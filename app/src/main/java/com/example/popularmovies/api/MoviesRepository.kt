package com.example.popularmovies.api

import retrofit2.Call

class MoviesRepository {
    private val moviesApi: MoviesApiService = MoviesApi.createApi()

    fun getMovies(year: String): Call<MoviesResult> = moviesApi.getCorrectMovies(year)
}