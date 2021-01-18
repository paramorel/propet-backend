package com.example.propetbackend.repository.dto

import org.joda.time.DateTime
import java.io.Serializable

data class CreateNewsDto(
    val userId: Long,
    val title: String,
    val content: String,
    val publicationDate: DateTime
) : Serializable