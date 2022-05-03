package com.darienalvarez.codechallenge.domain.api

import android.content.Context
import com.darienalvarez.codechallenge.R
import com.darienalvarez.codechallenge.domain.model.json.TransactionJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * API to retrieve Employees information
 */
interface TransactionSource {

    /**
     * Gets a list of Employees
     */
    suspend fun getTransactions(): List<TransactionJson>?
}

class TransactionSourceImpl(
    private val applicationContext: Context,
    private val moshi: Moshi
) : TransactionSource {

    private val moshiAdapter: JsonAdapter<List<TransactionJson>>

    init {
        val listType = Types.newParameterizedType(List::class.java, TransactionJson::class.java)

        moshiAdapter = moshi.adapter(listType)
    }

    override suspend fun getTransactions(): List<TransactionJson>? = withContext(Dispatchers.IO) {
        val jsonText =
            applicationContext.resources.openRawResource(R.raw.transactions).bufferedReader().use {
                it.readText()
            }

        moshiAdapter.fromJson(jsonText)
    }
}