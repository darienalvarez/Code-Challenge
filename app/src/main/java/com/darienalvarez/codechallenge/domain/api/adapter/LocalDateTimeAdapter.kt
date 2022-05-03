package com.darienalvarez.codechallenge.domain.api.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class LocalDateTimeAdapter {

    @ToJson
    fun toJson(@JsonDateTime localDateTime: LocalDateTime): String {
        return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(localDateTime)
    }

    @FromJson
    @JsonDateTime
    fun fromJson(value: String): LocalDateTime {
        return LocalDateTime.from(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse(value))
    }
}