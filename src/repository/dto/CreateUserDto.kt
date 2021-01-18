package com.example.propetbackend.repository.dto

import java.io.Serializable

data class CreateUserDto(
    val email: String,
    val password: String
) : Serializable