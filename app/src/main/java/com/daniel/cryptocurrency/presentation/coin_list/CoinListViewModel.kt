package com.daniel.cryptocurrency.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daniel.cryptocurrency.common.Resource
import com.daniel.cryptocurrency.domain.use_case.get_coin_list.GetCoinListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val useCase: GetCoinListUseCase
) : ViewModel(){

    private val _state = mutableStateOf(CoinListState())
    val state : State<CoinListState> = _state

    init {
        getCoinList()
    }

    private fun getCoinList() {
        useCase().onEach { result ->
            when(result){
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }

                is Resource.Success -> {
                    result.data?.let {
                        _state.value = CoinListState(coins = it)
                    }
                }
                is Resource.Error -> {
                    _state.value = CoinListState(
                        error = result.message ?:"An unexpected error"
                    )
                }
            }
        }.launchIn(viewModelScope)

    }
}