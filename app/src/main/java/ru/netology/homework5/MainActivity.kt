package ru.netology.homework5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels

import ru.netology.homework5.databinding.ActivityMainBinding

import ru.netology.homework5.viewmodel.PostViewModel


class MainActivity : AppCompatActivity() {

    private val viewModel: PostViewModel by viewModels()
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        subscribe()
        setupListeners()


    }

    private fun subscribe() {

        viewModel.data.observe(this) { post ->
            binding.apply {
                author.text = post.author
                published.text = post.published
                content.text = post.content
                countView.text = DisplayingNumbers(post.view)
                countLikes.text = DisplayingNumbers(post.like)
                countShares.text = DisplayingNumbers(post.share)
                likes.setImageResource(
                    if (post.likedByMe)
                        R.drawable.ic_baseline_favorite_24
                    else R.drawable.ic_baseline_favorite_border_24
                )
            }
        }
    }


    private fun setupListeners() {
        viewModel.data.observe(this) { post ->
            binding.apply {
                likes.setOnClickListener {
                    viewModel.like()

                }
                share.setOnClickListener {
                    viewModel.share()

                }

                view.setOnClickListener {
                    viewModel.view()
                }
            }
        }

    }

}






