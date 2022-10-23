package ru.netology.homework5.repository;

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.homework5.DisplayingNumbers

import ru.netology.homework5.dto.Post

class PostRepositoryInMemoryImpl : PostRepository {

    private var post = Post(
        id = 1,
        author = "Нетология. Университет интернет-профессий будущего",
        content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
        published = "21 мая в 18:36",
        likedByMe = false,
        sharedByMe = false,
        viewedByMe = false
    )
    private val data = MutableLiveData(post)

    override fun get(): LiveData<Post> = data
    override fun like(){
        post = post.copy(likedByMe = !post.likedByMe,
            like = if (post.likedByMe) post.like - 1 else post.like +1)
        data.value = post
    }

    override fun share() {
        post=post.copy(sharedByMe = !post.sharedByMe,
            share = post.share +10_000 )
        data.value = post

    }

    override fun view() {
        post = post.copy(
            viewedByMe = !post.viewedByMe,
            view =  post.view + 10_000 )
        data.value = post
    }
}