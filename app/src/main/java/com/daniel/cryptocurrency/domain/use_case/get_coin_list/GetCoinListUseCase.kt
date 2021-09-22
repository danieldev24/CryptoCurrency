package com.daniel.cryptocurrency.domain.use_case.get_coin_list

import com.daniel.cryptocurrency.common.Resource
import com.daniel.cryptocurrency.domain.model.Coin
import com.daniel.cryptocurrency.domain.model.toCoin
import com.daniel.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinListUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoinList().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e : HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error"))
        } catch (e : IOException){
            emit(Resource.Error<List<Coin>>("Couldn't reach server.Check your internet connect!"))
        }
    }
}