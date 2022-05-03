package com.darienalvarez.codechallenge.domain.exception

/**
 * To handle 401
 */
class ApiInvalidSessionException(
    message: String? = null,
    ex: Exception? = null
) : ApiException(message, ex)