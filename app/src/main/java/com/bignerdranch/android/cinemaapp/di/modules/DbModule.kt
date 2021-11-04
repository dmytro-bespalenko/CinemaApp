package com.bignerdranch.android.cinemaapp.di.modules

import android.app.Application
import androidx.room.Room
import com.bignerdranch.android.cinemaapp.data.local.AppDatabase
import com.bignerdranch.android.cinemaapp.data.local.dao.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {

    @Provides
    @Singleton
    internal fun provideDataBase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "Entertainment.db")
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    internal fun provideMovieDao(appDatabase: AppDatabase): MovieDao {
        return appDatabase.movieDao()
    }



}