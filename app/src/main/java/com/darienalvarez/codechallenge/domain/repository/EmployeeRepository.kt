package com.darienalvarez.codechallenge.domain.repository

import com.darienalvarez.codechallenge.domain.api.TransactionSource
import com.darienalvarez.codechallenge.domain.model.dto.TransactionDto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface EmployeeRepository {

    /**
     * Gets a list of employees
     *
     * @return the list of employees
     */
    suspend fun getTransactions(): List<TransactionDto>?
}

class EmployeeRepositoryImpl @Inject constructor(
    private val transactionSource: TransactionSource,
    private val dispatcher: CoroutineDispatcher
) : EmployeeRepository {

    override suspend fun getTransactions(): List<TransactionDto>? = withContext(dispatcher) {
        transactionSource.getTransactions()?.map {
            TransactionDto.fromTransaction(it)
        }
    }
}