package com.bignerdranch.android.cinemaapp.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.cinemaapp.data.Resource
import com.bignerdranch.android.cinemaapp.data.local.dao.MovieDao
import com.bignerdranch.android.cinemaapp.data.local.entity.MovieEntity
import com.bignerdranch.android.cinemaapp.data.remote.api.MovieApiService
import com.bignerdranch.android.cinemaapp.data.remote.repository.MovieRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class MovieListViewModel @Inject constructor(
    movieDao: MovieDao,
    movieApiService: MovieApiService
) :
    ViewModel() {

    private val movieRepository: MovieRepository = MovieRepository(movieDao, movieApiService)

    private val moviesListLiveData = MutableLiveData<Resource<List<MovieEntity>>>()

    private val disposableBag = CompositeDisposable()

    fun loadMoreMovies() {
      disposableBag.add( movieRepository.loadMoviesByType()
            .subscribe { movies ->
                getMoviesLiveData().postValue(movies)
            })
    }

    fun getMoviesLiveData() = moviesListLiveData


    override fun onCleared() {
        super.onCleared()
        disposableBag.clear()
    }

}