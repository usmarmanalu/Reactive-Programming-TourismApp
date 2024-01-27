package com.dicoding.tourismapp.core.data.di

import androidx.room.*
import com.dicoding.tourismapp.core.data.*
import com.dicoding.tourismapp.core.data.source.local.*
import com.dicoding.tourismapp.core.data.source.local.room.*
import com.dicoding.tourismapp.core.data.source.remote.*
import com.dicoding.tourismapp.core.data.source.remote.network.*
import com.dicoding.tourismapp.core.domain.repository.*
import com.dicoding.tourismapp.core.utils.*
import okhttp3.*
import okhttp3.logging.*
import org.koin.android.ext.koin.*
import org.koin.dsl.*
import retrofit2.*
import retrofit2.converter.gson.*
import java.util.concurrent.*

val databaseModule = module {
    factory {
        get<TourismDatabase>().tourismDao()
    }
    single {
        Room.databaseBuilder(
            androidContext(),
            TourismDatabase::class.java, "Tourism.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://tourism-api.dicoding.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<ITourismRepository> { TourismRepository(get(), get(), get()) }
}