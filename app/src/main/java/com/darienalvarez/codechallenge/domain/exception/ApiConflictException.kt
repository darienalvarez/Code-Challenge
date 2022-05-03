package com.darienalvarez.codechallenge.domain.exception

/**
 * To handle 409
 */
class ApiConflictException(
    message: String? = null,
    ex: Exception? = null
) : ApiException(message, ex)