package com.example.propetbackend.repository

import com.example.propetbackend.database.dbQuery
import com.example.propetbackend.repository.dto.CreateNewsDto
import com.example.propetbackend.repository.extensions.toNews
import io.ktor.http.content.resourceClasspathResource
import model.News
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.update

class NewsRepository {
    suspend fun getAllNews() =
        dbQuery {
            com.example.propetbackend.repository.tables.News.selectAll().map { it.toNews() }
    }

    suspend fun addNews(createNewsDto: CreateNewsDto){
        dbQuery {
            com.example.propetbackend.repository.tables.News.insert{ insertStatement ->
                insertStatement[userId] = createNewsDto.userId
                insertStatement[title] = createNewsDto.title
                insertStatement[content] = createNewsDto.content
                insertStatement[publicationDate] = createNewsDto.publicationDate
            }
        }
    }

    suspend fun deleteNews(id: Long){
        dbQuery {
            com.example.propetbackend.repository.tables.News.deleteWhere {
                com.example.propetbackend.repository.tables.News.newsId.eq(id)
            }
        }
    }

    suspend fun updateNews(news: News){
        dbQuery {
            com.example.propetbackend.repository.tables.News.update(
                { com.example.propetbackend.repository.tables.News.newsId eq news.newsId }
            ) {
                it[title] = news.title
                it[content] = news.content
            }
        }
    }
}