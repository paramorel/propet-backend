package model;

import org.joda.time.DateTime
import java.io.Serializable

data class News(
    val newsId: Long,
    val userId: Long,
    val title: String,
    val content: String,
    val publicationDate: DateTime
) : Serializable

