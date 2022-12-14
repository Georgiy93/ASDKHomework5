package ru.netology.homework5.viewmodel

import androidx.lifecycle.ViewModel
import ru.netology.homework5.repository.PostRepository
import ru.netology.homework5.repository.PostRepositoryInMemoryImpl

class PostViewModel : ViewModel() {

    private val repository: PostRepository = PostRepositoryInMemoryImpl()
    val data = repository.get()
    fun like() = repository.like()
    fun share() = repository.share()
    fun view() = repository.view()
}
