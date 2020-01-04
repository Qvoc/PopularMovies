package com.example.popularmovies.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.popularmovies.api.MoviesRepository
import com.example.popularmovies.api.MoviesResult
import com.example.popularmovies.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val moviesRepository = MoviesRepository()
    val movie = MutableLiveData<List<Movie>>()
    val error = MutableLiveData<String>()

    /**
     * Get movie data from the repository using Retrofit.
     * onResponse if the response is successful populate the [movie] object.
     * If the call encountered an error then populate the [error] object.
     */
    fun getCorrectMovies(year: String) {
        moviesRepository.getMovies(year).enqueue(object : Callback<MoviesResult> {

            override fun onResponse(call: Call<MoviesResult>, response: Response<MoviesResult>) {
                if (response.isSuccessful) {
                    movie.value = response.body()?.resultMovie
                } else error.value = "An error occurred: ${response.errorBody().toString()}"
            }

            override fun onFailure(call: Call<MoviesResult>, t: Throwable) {
                error.value = t.message
            }
        })
    }
}
