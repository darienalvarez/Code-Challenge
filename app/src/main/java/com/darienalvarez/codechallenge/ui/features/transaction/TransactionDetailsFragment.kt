package com.darienalvarez.codechallenge.ui.features.transaction

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.darienalvarez.codechallenge.R
import com.darienalvarez.codechallenge.databinding.FragmentTransactionDetailsBinding
import com.darienalvarez.codechallenge.ui.core.BaseFragment
import com.darienalvarez.codechallenge.ui.core.BaseState

class TransactionDetailsFragment:
    BaseFragment<FragmentTransactionDetailsBinding, TransactionDetailsViewModel>() {

    override val contentLayoutId: Int = R.layout.fragment_transaction_details

    override val viewModel: TransactionDetailsViewModel by viewModels()

    private val args: TransactionDetailsFragmentArgs by navArgs()

    override fun setupView(view: View, savedInstanceState: Bundle?) {
        binding.transaction = args.transaction
    }

    override fun onStateChange(state: BaseState) {

    }
}