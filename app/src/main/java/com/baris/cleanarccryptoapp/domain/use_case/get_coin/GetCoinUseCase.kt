package com.baris.cleanarccryptoapp.domain.use_case.get_coin

import com.baris.cleanarccryptoapp.common.Resource
import com.baris.cleanarccryptoapp.data.remote.dto.toCoinDetail
import com.baris.cleanarccryptoapp.domain.model.Coin
import com.baris.cleanarccryptoapp.domain.model.CoinDetail
import com.baris.cleanarccryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException){
            emit(Resource.Error<CoinDetail>(message = e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException){
            emit(Resource.Error<CoinDetail>(message = "Couldn't reach server. Check your internet connection"))
        }
    }

}