package com.darienalvarez.codechallenge.ui.features.transaction

import androidx.fragment.app.Fragment
import com.darienalvarez.codechallenge.domain.model.dto.TransactionDto
import com.darienalvarez.codechallenge.ui.navigation.NavCommons


interface TransactionsDestination {

    fun goToDetails(fragment: Fragment?, transaction: TransactionDto)
}

class TransactionsDestinationImpl(private val navCommons: NavCommons) : TransactionsDestination {

    override fun goToDetails(fragment: Fragment?, transaction: TransactionDto) {
        val action =
            TransactionListFragmentDirections.actionEmployeeListFragmentToTransactionDetailsFragment(
                transaction
            )
        navCommons.goToFragment(fragment, action)
    }
}