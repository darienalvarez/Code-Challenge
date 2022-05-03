package com.darienalvarez.codechallenge.ui.common

/**
 * Callback interface to handle click events
 */
interface OnItemClick<T> {

    /**
     * On click on an item
     *
     * @param item the selected item
     */
    fun onClick(item: T)
}