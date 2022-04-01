package com.algebra.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.algebra.mvvm.model.Movie
import com.algebra.mvvm.ui.MoviesViewModel
import com.algebra.mvvm.utils.Injector
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity( ) {

    override fun onCreate( savedInstanceState : Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        setupUI( )
    }

    private fun setupUI( ) {
        val factory = Injector.provideMoviesViewModelFactory( )
        val viewModel = ViewModelProvider( this, factory ).get( MoviesViewModel::class.java )

        viewModel.getMovies( ).observe( this, Observer { movies ->
            val sb = StringBuilder( )
            movies.forEach {
                sb.append( "$it\n" )
            }
            tvMovies.text = sb.toString( )
        } )

        bAddMovie.setOnClickListener {
            val movie = Movie( etTitle.text.toString( ).trim( ), etDirector.text.toString( ).trim( ) )
            viewModel.addMovie( movie )
            etTitle.text.clear( )
            etDirector.text.clear( )
            etTitle.requestFocus( )
        }
    }
}