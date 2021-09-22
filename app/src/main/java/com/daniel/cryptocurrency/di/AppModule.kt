package com.daniel.cryptocurrency.di

import com.daniel.cryptocurrency.common.Constants
import com.daniel.cryptocurrency.data.remote.CoinApi
import com.daniel.cryptocurrency.data.repository.CoinRepositoryImpl
import com.daniel.cryptocurrency.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinApi() : CoinApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api : CoinApi) : CoinRepository {
        return CoinRepositoryImpl(api)
    }
}