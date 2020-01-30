package com.example.githubapp.repo

import com.example.githubapp.data.Model
import retrofit2.Call

interface IGitRepo {
    fun loadAllRepos(): Call<MutableList<Model>>
}