package com.example.githubapp.provider

import com.example.githubapp.api.GitApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiProvides {

    private const val BASE_URL = "https://api.github.com/"
    const val MY_REPOS = "users/Bayramali1999/repos"
    const val MY_COMMITS = "repos/Bayramali1999/{name}/commits"

    var apiInstance: GitApi? = null
    fun create(): GitApi {
        if (apiInstance == null) {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            apiInstance = retrofit.create(GitApi::class.java)
        }
        return apiInstance!!
    }
}