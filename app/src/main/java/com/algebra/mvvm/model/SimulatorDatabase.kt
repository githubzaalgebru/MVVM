package com.algebra.mvvm.model

class SimulatorDatabase private constructor( ) {

    val movieDao = SimulatorMovieDao( )

    companion object {
        @Volatile
        private var instance : SimulatorDatabase? = null

        fun getInstance( ) = instance ?: synchronized( this ) {
            instance ?: SimulatorDatabase( ).also { instance = it }
        }
    }
}