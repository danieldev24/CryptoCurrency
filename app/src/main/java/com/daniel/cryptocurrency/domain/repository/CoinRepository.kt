package com.daniel.cryptocurrency.domain.repository

import com.daniel.cryptocurrency.data.remote.dto.CoinDTO
import com.daniel.cryptocurrency.data.remote.dto.CoinDetailDTO

interface CoinRepository {

    suspend fun getCoinList() : List<CoinDTO>

    suspend fun getCoinById(coinId : String) : CoinDetailDTO
}