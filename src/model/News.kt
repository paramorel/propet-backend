package model;

import java.io.Serializable

data class News(
    val title: String,
    val content: String,
    val date: String,
    val author: String? = null
) : Serializable

