package com.darienalvarez.codechallenge.ui.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import timber.log.Timber

interface BaseState

object CreatedState: BaseState

abstract class BaseViewModel: ViewModel() {

    private val mutableState = MutableStateFlow<BaseState>(CreatedState)
    val state: StateFlow<BaseState>
        get() = mutableState

    protected fun setState(state: BaseState) {
        mutableState.value = state
    }

    override fun onCleared() {
        super.onCleared()

        Timber.d("event: onCleared")
    }
}