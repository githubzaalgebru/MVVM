package com.algebra.mvvm.utils

import com.algebra.mvvm.model.MovieRepository
import com.algebra.mvvm.model.SimulatorDatabase
import com.algebra.mvvm.ui.MoviesViewModelFactory

object Injector {
    fun provideMoviesViewModelFactory( ) : MoviesViewModelFactory {
        val movieRepository =
            MovieRepository.getInstance( SimulatorDatabase.getInstance( ).movieDao )

        return MoviesViewModelFactory( movieRepository )
    }
}