package com.darienalvarez.codechallenge.domain.exception

/**
 * To handle 404
 */
class ApiNotFoundException(
    message: String? = null,
    ex: Exception? = null
) : ApiException(message, ex)