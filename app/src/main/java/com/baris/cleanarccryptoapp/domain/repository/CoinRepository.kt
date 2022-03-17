package com.baris.cleanarccryptoapp.domain.repository

import com.baris.cleanarccryptoapp.data.remote.dto.CoinDetailDto
import com.baris.cleanarccryptoapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

}