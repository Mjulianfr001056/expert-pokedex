package com.example.simplepokedex.data

import com.example.simplepokedex.data.local.PokemonDao
import com.example.simplepokedex.data.stub.PokemonList
import com.example.simplepokedex.domain.model.Pokemon
import com.example.simplepokedex.util.Error
import com.example.simplepokedex.util.GeneralError
import com.example.simplepokedex.util.PokemonMapper
import com.example.simplepokedex.util.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class PokemonRepositoryImpl(
    private val dao: PokemonDao
) : PokemonRepository {
    override fun getAllPokemon(): Flow<Result<List<Pokemon>, Error>> {
        return flow {
            try {
                val response = PokemonList.list.map {
                    PokemonMapper.toDomain(it)
                }
                emit(Result.Success(response))
            } catch (e: Exception) {
                emit(Result.Error(GeneralError.IO_ERROR))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getPokemonById(id: Int): Flow<Result<Pokemon, Error>> {
        return flow {
            try {
                val response = PokemonList.list.find { it.id == id }
                if (response != null) {
                    emit(Result.Success(PokemonMapper.toDomain(response)))
                } else {
                    emit(Result.Error(GeneralError.NOT_FOUND))
                }
            } catch (e: Exception) {
                emit(Result.Error(GeneralError.IO_ERROR))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun searchPokemon(query: String): Flow<Result<List<Pokemon>, Error>> {
        return flow {
            try {
                val response = PokemonList.list.filter {
                    it.name.contains(query, ignoreCase = true)
                }.map {
                    PokemonMapper.toDomain(it)
                }
                emit(Result.Success(response))
            } catch (e: Exception) {
                emit(Result.Error(GeneralError.IO_ERROR))
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun savePokemon(pokemon: Pokemon): Result<Unit, Error> {
        return try {
            dao.insertPokemon(PokemonMapper.toEntity(pokemon))
            Result.Success(Unit)
        } catch (e: Exception) {
            Result.Error(GeneralError.IO_ERROR)
        }
    }

    override suspend fun deletePokemon(pokemon: Pokemon): Result<Unit, Error> {
        return try {
            dao.delete(PokemonMapper.toEntity(pokemon))
            Result.Success(Unit)
        } catch (e: Exception) {
            Result.Error(GeneralError.IO_ERROR)
        }
    }

    override suspend fun isFavoritePokemon(id: Int): Flow<Result<Boolean, Error>> {
        return dao.getById(id).map {
            Result.Success(it != null)
        }
    }

    override fun getAllFavoritePokemon(): Flow<Result<List<Pokemon>, Error>> {
        return dao.getAll().map {
            Result.Success(it.map { PokemonMapper.toDomain(it) })
        }
    }
}