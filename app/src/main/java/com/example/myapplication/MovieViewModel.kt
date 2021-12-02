package com.example.myapplication

import androidx.lifecycle.ViewModel

class MovieViewModel: ViewModel() {
    val movieList = listOf(
        MovieItem("The wizard of Oz(1939)", "9.0", "DRAMA", "1930", R.drawable.movie1),
        MovieItem("Citizen Kane(1941)", "9.0", "DRAMA", "1930", R.drawable.movie2),
        MovieItem("All about Eve(1950)", "9.0", "DRAMA", "1930", R.drawable.movie3),
        MovieItem("The third man(1949)", "9.0", "DRAMA", "1930", R.drawable.movie4),
        MovieItem("A hard day's night(1964)", "9.0", "DRAMA", "1930", R.drawable.movie5),
        MovieItem("Modern times(1936)", "9.0", "DRAMA", "1930", R.drawable.movie6),
        MovieItem("Metropolis(1927)", "9.0", "DRAMA", "1930", R.drawable.movie7),
        MovieItem("Metropolis(1927)", "9.0", "DRAMA", "1930", R.drawable.movie7),
        MovieItem("Metropolis(1927)", "9.0", "DRAMA", "1930", R.drawable.movie7),
    )
}