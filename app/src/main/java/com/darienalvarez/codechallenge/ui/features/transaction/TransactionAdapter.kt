package com.darienalvarez.codechallenge.ui.features.transaction

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.darienalvarez.codechallenge.databinding.ItemTransactionBinding
import com.darienalvarez.codechallenge.domain.model.dto.TransactionDto
import com.darienalvarez.codechallenge.ui.common.OnItemClick

/**
 * [RecyclerView.Adapter] that can display an [TransactionDto].
 */
class TransactionAdapter(private val onItemClick: OnItemClick<TransactionDto>): ListAdapter<TransactionDto, TransactionAdapter.TransactionViewHolder>(
    TransactionDiffCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val binding = ItemTransactionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        binding.onClick = onItemClick

        return TransactionViewHolder(binding)
    }

    override fun onBindViewHolder(holderTransaction: TransactionViewHolder, position: Int) {
        holderTransaction.bind(getItem(position))
    }

    object TransactionDiffCallback : DiffUtil.ItemCallback<TransactionDto>() {
        override fun areItemsTheSame(oldItem: TransactionDto, newItem: TransactionDto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TransactionDto, newItem: TransactionDto): Boolean {
            return oldItem == newItem
        }
    }

    inner class TransactionViewHolder(private val binding: ItemTransactionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(transaction: TransactionDto) {
            binding.transaction = transaction
        }
    }

}