package com.daniel.cryptocurrency.presentation.coin_list

import com.daniel.cryptocurrency.common.Resource
import com.daniel.cryptocurrency.domain.model.Coin

data class CoinListState(
    var isLoading: Boolean = false,
    var coins : List<Coin> = emptyList(),
    var error : String = ""
)
