package com.darienalvarez.codechallenge.domain.exception

/**
 * Endpoint not reachable UnknownHostException, UnknownServiceException
 */
class ApiServerUnknownException(message: String? = null, ex: Exception? = null) :
    ApiException(message, ex)