package com.ydhnwb.starter_app_mvvm

import android.app.Application
import com.ydhnwb.starter_app_mvvm.di.modules.ViewModelModule
import org.koin.core.context.startKoin

class BaseApp : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(ViewModelModule.viewModelModules))
        }
    }
}