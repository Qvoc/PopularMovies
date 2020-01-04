package com.example.popularmovies.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.popularmovies.R
import com.example.popularmovies.api.MoviesApi
import com.example.popularmovies.model.Movie

import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.content_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    private val imageBaseUrl = "https://image.tmdb.org/t/p/w500/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.movie_detail_title)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initViews()
    }

    private fun initViews() {
        val movie: Movie = intent.getParcelableExtra(DETAIL_MOVIE)
        Glide.with(this).load(imageBaseUrl + movie.backdrop).into(ivBackdrop)
        Glide.with(this).load(imageBaseUrl + movie.poster).into(ivPoster)

        tvTitle.text = movie.title
        tvReleaseDate.text = this.getString(R.string.release_date, movie.date)
        tvRating.text = movie.rating.toString()
        tvOverview.text = movie.overview
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
