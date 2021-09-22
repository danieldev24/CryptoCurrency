package com.daniel.cryptocurrency.data.repository

import com.daniel.cryptocurrency.data.remote.CoinApi
import com.daniel.cryptocurrency.data.remote.dto.CoinDTO
import com.daniel.cryptocurrency.data.remote.dto.CoinDetailDTO
import com.daniel.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinApi: CoinApi
) : CoinRepository {
    override suspend fun getCoinList(): List<CoinDTO> {
        return coinApi.getCoinList()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDTO {
       return coinApi.getCoinById(coinId = coinId)
    }
}