package ru.netology.homework5.repository;

import androidx.lifecycle.LiveData

import ru.netology.homework5.dto.Post



interface PostRepository {
    fun get(): LiveData<Post>
    fun like()
    fun share()
    fun view()
}
