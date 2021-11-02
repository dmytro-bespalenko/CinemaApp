package com.bignerdranch.android.cinemaapp.data.remote.model

import com.bignerdranch.android.cinemaapp.data.local.entity.MovieEntity

data class MovieApiResponse(
    val page: Long,
    val result: List<MovieEntity>,
    val total_result: Long,
    val total_page: Long
)
