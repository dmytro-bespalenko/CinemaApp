package com.bignerdranch.android.cinemaapp.data.local

import androidx.room.Database
import com.bignerdranch.android.cinemaapp.data.local.dao.MovieDao
import com.bignerdranch.android.cinemaapp.data.local.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase {

    abstract fun movieDao(): MovieDao
}