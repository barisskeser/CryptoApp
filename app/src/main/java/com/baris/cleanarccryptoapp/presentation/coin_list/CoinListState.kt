package com.baris.cleanarccryptoapp.presentation.coin_list

import com.baris.cleanarccryptoapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)