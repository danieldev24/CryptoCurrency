package com.daniel.cryptocurrency.data.remote

import com.daniel.cryptocurrency.data.remote.dto.CoinDTO
import com.daniel.cryptocurrency.data.remote.dto.CoinDetailDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {

    @GET("/v1/coins")
    suspend fun getCoinList() : List<CoinDTO>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId : String) : CoinDetailDTO
}