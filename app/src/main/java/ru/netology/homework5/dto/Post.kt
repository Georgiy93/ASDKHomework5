package ru.netology.homework5.dto

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    var like: Long = 0,
    var share: Long = 0,
    var view: Long = 0,
    val likedByMe: Boolean = false,
    val sharedByMe: Boolean = false,
    val viewedByMe: Boolean = false
)