package com.example.belajarandroid

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.belajarandroid.model.Article
import com.example.belajarandroid.network.Api
import kotlinx.coroutines.launch

class NewsViewModel: ViewModel() {
    init{
        getListNews()
    }

    fun getListNews(){
        viewModelScope.launch {
            val response = Api.newsApiService.getTopHeadline()
            val articles = response.articles

            articles.forEach { article: Article ->
                Log.d("response", article.toString())
            }
        }
    }
}