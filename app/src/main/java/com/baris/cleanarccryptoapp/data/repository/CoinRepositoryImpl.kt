package com.baris.cleanarccryptoapp.data.repository

import com.baris.cleanarccryptoapp.data.remote.CoinPaprikaApi
import com.baris.cleanarccryptoapp.data.remote.dto.CoinDetailDto
import com.baris.cleanarccryptoapp.data.remote.dto.CoinDto
import com.baris.cleanarccryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}