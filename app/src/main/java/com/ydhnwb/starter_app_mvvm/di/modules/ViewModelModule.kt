package com.ydhnwb.starter_app_mvvm.di.modules

import com.ydhnwb.starter_app_mvvm.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModule {
    val viewModelModules = module {
        viewModel {
            MainViewModel()
        }
    }
}