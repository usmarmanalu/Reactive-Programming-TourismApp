package com.dicoding.tourismapp.favorite

import androidx.lifecycle.*
import com.dicoding.tourismapp.core.domain.usecase.*

class FavoriteViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
    val favoriteTourism = tourismUseCase.getFavoriteTourism().asLiveData()
}

