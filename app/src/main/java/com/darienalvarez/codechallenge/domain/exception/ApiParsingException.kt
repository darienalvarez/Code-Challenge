package com.darienalvarez.codechallenge.domain.exception

/**
 * Parsing Json Exception
 */
class ApiParsingException(message: String? = null, ex: Exception? = null) :
    ApiException(message, ex)