package com.darienalvarez.codechallenge.domain.exception

/**
 * When the operation is not supported
 */
class UnsupportedOperationException(message: String = "Unsupported operation"): Exception(message)