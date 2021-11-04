package com.bignerdranch.android.cinemaapp

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class AppController : Application() {

//    @Inject
//    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
//
//    override fun activityInjector(): AndroidInjector<Activity> {
//        return dispatchingAndroidInjector
//    }

    override fun onCreate() {
        super.onCreate(
//            DaggerAppComponent.builder()
//                .application(this)
//                .build()
//                .inject(this)
        )
    }

}