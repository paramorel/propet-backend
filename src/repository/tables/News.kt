package com.example.propetbackend.repository.tables

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import org.joda.time.DateTime

object News : Table() {
    val newsId: Column<Long> = News.long("news_id").autoIncrement().primaryKey()
    val userId: Column<Long> = News.long("user_id").references(Users.userId)
    val title: Column<String> = News.text("title")
    val content: Column<String> = News.text("content")
    val publicationDate: Column<DateTime> = News.date("pub_date")
}