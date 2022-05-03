package com.darienalvarez.codechallenge.ui.features.transaction

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.darienalvarez.codechallenge.domain.model.dto.TransactionDto
import com.darienalvarez.codechallenge.domain.repository.TransactionRepository
import com.darienalvarez.codechallenge.ui.core.BaseState
import com.darienalvarez.codechallenge.ui.core.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionListViewModel @Inject constructor(
    private val repository: TransactionRepository,
    private val savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    sealed class TransactionListState : BaseState {
        object Loading : TransactionListState()

        data class Success(
            val stateStamp: Long = System.currentTimeMillis(),
            val transactions: List<TransactionDto>
        ) : TransactionListState()

        data class Fail(
            val stateStamp: Long = System.currentTimeMillis(),
            val exception: Exception
        ) : TransactionListState()
    }

    fun getTransactions() {
        viewModelScope.launch {
            try {
                setState(TransactionListState.Loading)

                val transactions = repository.getTransactions()
                val state = transactions?.let {
                    TransactionListState.Success(transactions = it)
                } ?: TransactionListState.Fail(exception = IllegalArgumentException("not found"))

                setState(state)
            } catch (e: Exception) {
                setState(TransactionListState.Fail(exception = e))
            }
        }
    }
}