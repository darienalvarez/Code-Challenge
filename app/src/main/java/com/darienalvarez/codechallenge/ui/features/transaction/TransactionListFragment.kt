package com.darienalvarez.codechallenge.ui.features.transaction

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.darienalvarez.codechallenge.R
import com.darienalvarez.codechallenge.databinding.FragmentTransactionListBinding
import com.darienalvarez.codechallenge.domain.model.dto.TransactionDto
import com.darienalvarez.codechallenge.ui.common.OnItemClick
import com.darienalvarez.codechallenge.ui.core.BaseFragment
import com.darienalvarez.codechallenge.ui.core.BaseState
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

/**
 * A fragment representing a list of Transactions.
 */
@AndroidEntryPoint
class TransactionListFragment :
    BaseFragment<FragmentTransactionListBinding, TransactionListViewModel>(), OnItemClick<TransactionDto> {

    override val contentLayoutId: Int = R.layout.fragment_transaction_list

    override val viewModel: TransactionListViewModel by viewModels()

    @Inject
    lateinit var destination: TransactionsDestination

    override fun setupView(view: View, savedInstanceState: Bundle?) {

        setHasOptionsMenu(true)

        binding.list.adapter = TransactionAdapter(this)

        binding.swipeContainer.setOnRefreshListener {
            viewModel.getTransactions()
        }

        viewModel.getTransactions()
    }

    override fun onStateChange(state: BaseState) {
        when (state) {
            TransactionListViewModel.TransactionListState.Loading -> handleLoading()

            is TransactionListViewModel.TransactionListState.Success -> handleSuccess(state.transactions)

            is TransactionListViewModel.TransactionListState.Fail -> handleFailure(state.exception)
        }
    }

    private fun handleLoading() {
        binding.swipeContainer.isRefreshing = true
    }

    private fun handleSuccess(transactions: List<TransactionDto>) {
        Timber.i("Retrieved %d transactions", transactions.size)

        showEmptyView(transactions.isEmpty())

        (binding.list.adapter as? TransactionAdapter)?.submitList(transactions)

        // Now we call setRefreshing(false) to signal refresh has finished
        binding.swipeContainer.isRefreshing = false
    }

    private fun showEmptyView(isEmpty: Boolean) {
        binding.list.isVisible = !isEmpty
        binding.empty.isVisible = isEmpty
    }

    private fun handleFailure(e: Exception) {
        // not handling exception
        Timber.e(e)

        // Now we call setRefreshing(false) to signal refresh has finished
        binding.swipeContainer.isRefreshing = false

        showRetryDialog()
    }

    private fun showRetryDialog() = context?.let {
        AlertDialog.Builder(it)
            .setCancelable(false)
            .setTitle(R.string.error_loading_title)
            .setMessage(R.string.error_loading_message)
            .setNegativeButton(R.string.cancel) { dialog, _ ->
                dialog.dismiss()

                showEmptyView(true)
            }
            .setPositiveButton(R.string.retry) { dialog, _ ->
                dialog.dismiss()

                viewModel.getTransactions()
            }
            .create()
            .show()
    }

    override fun onClick(item: TransactionDto) {
        destination.goToDetails(this, item)
    }
}