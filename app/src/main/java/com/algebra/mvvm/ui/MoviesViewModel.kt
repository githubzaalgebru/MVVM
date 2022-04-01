package com.algebra.mvvm.ui

import androidx.lifecycle.ViewModel
import com.algebra.mvvm.model.Movie
import com.algebra.mvvm.model.MovieRepository

class MoviesViewModel( private val movieRepository: MovieRepository ) : ViewModel( ) {

    fun getMovies( )               = movieRepository.getMovies( )
    fun addMovie( movie : Movie )  = movieRepository.addMovie( movie )
}