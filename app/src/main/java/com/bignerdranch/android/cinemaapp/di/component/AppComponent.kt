package com.bignerdranch.android.cinemaapp.di.component

import android.app.Application
import com.bignerdranch.android.cinemaapp.AppController
import com.bignerdranch.android.cinemaapp.di.modules.ActivityModule
import com.bignerdranch.android.cinemaapp.di.modules.ApiModule
import com.bignerdranch.android.cinemaapp.di.modules.DbModule
import com.bignerdranch.android.cinemaapp.di.modules.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Component(
    modules = [ActivityModule::class,
        ApiModule::class,
        DbModule::class,
        ViewModelModule::class,
        AndroidInjectionModule::class
    ]
)

@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(appController: AppController)

}