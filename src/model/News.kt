package model;

import io.ktor.http.ContentType
import java.io.Serializable

data class News(
    val title: String,
    val content: String,
    val date: String,
    val image: ContentType.Image? = null
) : Serializable

