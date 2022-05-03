package com.darienalvarez.codechallenge.system.di

import com.darienalvarez.codechallenge.domain.api.TransactionSource
import com.darienalvarez.codechallenge.domain.repository.TransactionRepository
import com.darienalvarez.codechallenge.domain.repository.TransactionRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideEmployeeRepository(
        transactionSource: TransactionSource,
    ): TransactionRepository {
        return TransactionRepositoryImpl(transactionSource, Dispatchers.IO)
    }
}