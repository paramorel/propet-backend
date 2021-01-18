package com.example.propetbackend.repository.extensions

import com.example.propetbackend.repository.tables.News
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toNews() = model.News(
    newsId = this[News.newsId],
    userId = this[News.userId],
    title = this[News.title],
    content = this[News.content],
    publicationDate = this[News.publicationDate]
)