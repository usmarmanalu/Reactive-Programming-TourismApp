package com.dicoding.tourismapp.core.data.source.remote

import android.annotation.*
import android.util.*
import com.dicoding.tourismapp.core.data.source.remote.network.*
import com.dicoding.tourismapp.core.data.source.remote.response.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class RemoteDataSource private constructor(private val apiService: ApiService) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }

    @SuppressLint("CheckResult")
    fun getAllTourism(): Flow<ApiResponse<List<TourismResponse>>> {

        //get data from remote api
        return flow {
            try {
                val response = apiService.getList()
                val dataArray = response.places
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.places))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}

