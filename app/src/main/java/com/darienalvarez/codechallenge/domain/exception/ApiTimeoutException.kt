package com.darienalvarez.codechallenge.domain.exception

/**
 * Endpoint timeout exception
 */
class ApiTimeoutException(message: String? = null, ex: Exception? = null) :
    ApiException(message, ex)
