package com.baris.cleanarccryptoapp.domain.use_case.get_coins

import com.baris.cleanarccryptoapp.common.Resource
import com.baris.cleanarccryptoapp.data.remote.dto.toCoin
import com.baris.cleanarccryptoapp.domain.model.Coin
import com.baris.cleanarccryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException){
            emit(Resource.Error<List<Coin>>(message = e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException){
            emit(Resource.Error<List<Coin>>(message = "Couldn't reach server. Check your internet connection"))
        }
    }

}