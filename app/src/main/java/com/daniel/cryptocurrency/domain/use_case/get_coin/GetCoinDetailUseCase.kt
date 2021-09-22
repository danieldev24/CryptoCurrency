package com.daniel.cryptocurrency.domain.use_case.get_coin

import com.daniel.cryptocurrency.common.Resource
import com.daniel.cryptocurrency.data.remote.dto.toCoinDetail
import com.daniel.cryptocurrency.domain.model.Coin
import com.daniel.cryptocurrency.domain.model.CoinDetail
import com.daniel.cryptocurrency.domain.model.toCoin
import com.daniel.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId : String) : Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e : HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error"))
        } catch (e : IOException){
            emit(Resource.Error<CoinDetail>("Couldn't reach server.Check your internet connect!"))
        }
    }
}