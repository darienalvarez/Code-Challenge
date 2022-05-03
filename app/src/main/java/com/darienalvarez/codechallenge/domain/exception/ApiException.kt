package com.darienalvarez.codechallenge.domain.exception


/**
 * General Exception
 */
open class ApiException @JvmOverloads constructor(
    message: String? = null,
    ex: Exception? = null
) : Exception(message, ex)