package com.darienalvarez.codechallenge.domain.exception

/**
 * To handle 500s
 */
class ApiInternalServerException(
    message: String? = null,
    ex: Exception? = null
) : ApiException(message, ex)