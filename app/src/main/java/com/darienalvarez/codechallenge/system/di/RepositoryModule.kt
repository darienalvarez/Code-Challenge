package com.darienalvarez.codechallenge.system.di

import com.darienalvarez.codechallenge.domain.api.TransactionSource
import com.darienalvarez.codechallenge.domain.repository.EmployeeRepository
import com.darienalvarez.codechallenge.domain.repository.EmployeeRepositoryImpl
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
    ): EmployeeRepository {
        return EmployeeRepositoryImpl(transactionSource, Dispatchers.IO)
    }
}