package com.daniel.cryptocurrency.presentation.coin_detail

import com.daniel.cryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    var isLoading: Boolean = false,
    var coinDetail : CoinDetail? = null,
    var error : String = ""
)