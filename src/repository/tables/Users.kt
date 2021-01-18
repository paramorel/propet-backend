package com.example.propetbackend.repository.tables

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object Users : Table() {
    val userId: Column<Long> = Users.long("user_id").primaryKey().autoIncrement()
    val email: Column<String> = Users.text("email")
    val password: Column<String> = Users.text("password")
}