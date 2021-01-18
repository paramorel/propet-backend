package com.example.propetbackend.model

import org.jetbrains.exposed.sql.Column
import java.io.Serializable

data class User(
    val userId: Long,
    val email: String,
    val password: String
) : Serializable