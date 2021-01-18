package com.example.propetbackend.repository.extensions

import com.example.propetbackend.model.User
import com.example.propetbackend.repository.tables.Users
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toUser() = User(
    userId = this[Users.userId],
    email = this[Users.email],
    password = this[Users.password]
)