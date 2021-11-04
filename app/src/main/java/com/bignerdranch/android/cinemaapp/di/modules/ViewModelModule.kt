package com.bignerdranch.android.cinemaapp.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.cinemaapp.factory.ViewModelFactory
import com.bignerdranch.android.cinemaapp.ui.main.viewmodel.MovieListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel::class)
    protected abstract fun movieListViewModel(movieListViewModel: MovieListViewModel): ViewModel

}