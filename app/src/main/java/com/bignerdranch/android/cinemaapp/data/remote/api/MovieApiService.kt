package com.bignerdranch.android.cinemaapp.data.remote.api

import com.bignerdranch.android.cinemaapp.data.remote.model.MovieApiResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface MovieApiService {

    @GET("movie/popular?language=en-US&region=US&page=1")
    fun fetchMoviesByType(): Observable<MovieApiResponse>

}