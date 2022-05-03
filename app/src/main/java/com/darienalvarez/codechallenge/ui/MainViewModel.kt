package com.darienalvarez.codechallenge.ui

import androidx.lifecycle.SavedStateHandle
import com.darienalvarez.codechallenge.ui.core.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    init {
        Timber.d("event: created")
    }

    override fun onCleared() {
        super.onCleared()

        Timber.d("event: onCleared")
    }
}