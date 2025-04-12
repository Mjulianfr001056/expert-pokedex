package com.example.simplepokedex.util

import com.example.library.core.Error
import com.example.library.core.Result
import com.example.library.core.onError
import com.example.library.core.onSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

abstract class NetworkBoundResource<ResultType, ResponseType> {

    private var result: Flow<Result<ResultType, Error>> = flow {
        val dbSource = loadFromDB().firstOrNull()

        if (shouldFetch(dbSource)) {
            createCall().firstOrNull()
                ?.onSuccess {
                    saveCallResult(it)
                    emitAll(loadFromDB().map { data -> Result.Success(data) })
                }
                ?.onError {
                    onFetchFailed()
                    emit(Result.Error(it))
                }
        } else {
            emitAll(loadFromDB().map { Result.Success(it) })
        }
    }

    protected open fun onFetchFailed() {}

    protected abstract fun loadFromDB(): Flow<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract suspend fun createCall(): Flow<Result<ResponseType, Error>>

    protected abstract suspend fun saveCallResult(response: ResponseType)

    fun asFlow(): Flow<Result<ResultType, Error>> = result
}