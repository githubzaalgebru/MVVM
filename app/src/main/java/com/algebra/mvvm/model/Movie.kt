package com.algebra.mvvm.model

data class Movie( val title : String, val director : String ) {
    override fun toString( ) : String = "$title - $director"
}