package com.dicoding.tourismapp.core.domain.usecase

import com.dicoding.tourismapp.core.data.*
import com.dicoding.tourismapp.core.domain.model.*
import kotlinx.coroutines.flow.*

interface TourismUseCase {
    fun getAllTourism(): Flow<Resource<List<Tourism>>>
    fun getFavoriteTourism(): Flow<List<Tourism>>
    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}