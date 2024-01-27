package com.dicoding.tourismapp.core.di

import com.dicoding.tourismapp.core.domain.usecase.*
import com.dicoding.tourismapp.detail.*
import com.dicoding.tourismapp.favorite.*
import com.dicoding.tourismapp.home.*
import org.koin.android.viewmodel.dsl.*
import org.koin.dsl.*

val useCaseModule = module {
    factory<TourismUseCase> { TourismInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailTourismViewModel(get()) }
}