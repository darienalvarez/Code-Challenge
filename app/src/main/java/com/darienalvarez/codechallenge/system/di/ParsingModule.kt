package com.darienalvarez.codechallenge.system.di

import android.content.Context
import com.darienalvarez.codechallenge.domain.api.TransactionSource
import com.darienalvarez.codechallenge.domain.api.TransactionSourceImpl
import com.darienalvarez.codechallenge.domain.api.adapter.LocalDateTimeAdapter
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ParsingModule {

    @Provides
    fun provideMoshi(): Moshi =
        Moshi.Builder().add(LocalDateTimeAdapter()).build()

    @Provides
    fun provideTransactionSource(
        @ApplicationContext
        context: Context,
        moshi: Moshi
    ): TransactionSource =
        TransactionSourceImpl(context, moshi)

}