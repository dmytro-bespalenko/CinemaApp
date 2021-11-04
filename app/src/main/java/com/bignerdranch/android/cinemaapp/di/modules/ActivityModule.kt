package com.bignerdranch.android.cinemaapp.di.modules

import com.bignerdranch.android.cinemaapp.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity
}