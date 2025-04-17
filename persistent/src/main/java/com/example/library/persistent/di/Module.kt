package com.example.library.persistent.di

import androidx.room.Room
import com.example.library.persistent.PokedexDatabase
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import org.koin.dsl.module

val persistentModule = module {
    single<PokedexDatabase> {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("dicoding".toCharArray())
        val factory = SupportFactory(passphrase)

        Room.databaseBuilder(
            get(),
            PokedexDatabase::class.java,
            "pokedex_db")
            .fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }

    includes(daoModule)
}