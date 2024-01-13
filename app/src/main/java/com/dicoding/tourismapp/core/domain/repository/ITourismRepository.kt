package com.dicoding.tourismapp.core.domain.repository

import com.dicoding.tourismapp.core.data.*
import com.dicoding.tourismapp.core.domain.model.*
import kotlinx.coroutines.flow.*

interface ITourismRepository {

    fun getAllTourism(): Flow<Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flow<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)

}