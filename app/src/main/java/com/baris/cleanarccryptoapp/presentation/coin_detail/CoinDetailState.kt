package com.baris.cleanarccryptoapp.presentation.coin_detail

import com.baris.cleanarccryptoapp.domain.model.Coin
import com.baris.cleanarccryptoapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)