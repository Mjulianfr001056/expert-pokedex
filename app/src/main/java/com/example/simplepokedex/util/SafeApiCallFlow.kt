package com.example.simplepokedex.util

import com.example.library.core.Result
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.serialization.SerializationException

fun <T> safeApiCallFlow(call: suspend () -> T): Flow<Result<T, NetworkError>> = flow {
    try {
        emit(Result.Success(call()))
    } catch (e: UnresolvedAddressException) {
        emit(Result.Error(NetworkError.NO_INTERNET))
    } catch (e: SerializationException) {
        emit(Result.Error(NetworkError.SERIALIZATION))
    } catch (e: ClientRequestException) {
        when (e.response.status.value) {
            401 -> emit(Result.Error(NetworkError.UNAUTHORIZED))
            408 -> emit(Result.Error(NetworkError.REQUEST_TIMEOUT))
            409 -> emit(Result.Error(NetworkError.CONFLICT))
            413 -> emit(Result.Error(NetworkError.PAYLOAD_TOO_LARGE))
            else -> emit(Result.Error(NetworkError.UNKNOWN))
        }
    } catch (e: ServerResponseException) {
        emit(Result.Error(NetworkError.SERVER_ERROR))
    } catch (e: Exception) {
        emit(Result.Error(NetworkError.UNKNOWN))
    }
}.flowOn(Dispatchers.IO)