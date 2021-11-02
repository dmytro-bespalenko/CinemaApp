package com.bignerdranch.android.cinemaapp.data.remote.repository

import com.bignerdranch.android.cinemaapp.data.NetworkBoundResource
import com.bignerdranch.android.cinemaapp.data.Resource
import com.bignerdranch.android.cinemaapp.data.local.dao.MovieDao
import com.bignerdranch.android.cinemaapp.data.local.entity.MovieEntity
import com.bignerdranch.android.cinemaapp.data.remote.api.MovieApiService
import com.bignerdranch.android.cinemaapp.data.remote.model.MovieApiResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Singleton

@Singleton
class MovieRepository(
    private val movieDao: MovieDao,
    private val movieApiService: MovieApiService
) {

    fun loadMoviesByType(): Observable<Resource<List<MovieEntity>>> {
        return object : NetworkBoundResource<List<MovieEntity>, MovieApiResponse>() {
            override fun saveCallResult(item: MovieApiResponse) {
                movieDao.insertMovies(item.result)
            }

            override fun shouldFetch(): Boolean {
                return true
            }

            override fun loadFromDb(): Flowable<List<MovieEntity>> {
                val movieEntities = movieDao.getMoviesByPage()
                return if (movieEntities.isEmpty()) {
                    Flowable.empty()
                } else {
                    Flowable.just(movieEntities)
                }

            }

            override fun createCall(): Observable<Resource<MovieApiResponse>> {

                return movieApiService.fetchMoviesByType()
                    .flatMap { movieApiResponse ->
                        Observable.just(
                            Resource.success(movieApiResponse)
                        )

                    }
            }


        }.getAsObservable()
    }
}