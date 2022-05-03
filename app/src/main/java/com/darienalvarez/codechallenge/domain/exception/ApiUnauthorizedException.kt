package com.darienalvarez.codechallenge.domain.exception

/**
 * To handle 403
 */
class ApiUnauthorizedException(
    message: String? = null,
    ex: Exception? = null
) : ApiException(message, ex)