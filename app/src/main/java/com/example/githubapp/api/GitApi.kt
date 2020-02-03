package com.example.githubapp.api

import com.example.githubapp.data.Model
import com.example.githubapp.data.commit.Commit
import com.example.githubapp.provider.ApiProvides.MY_COMMITS
import com.example.githubapp.provider.ApiProvides.MY_REPOS
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitApi {
    @GET(MY_REPOS)
    fun loadAllRepos(): Call<MutableList<Model>>


    @GET(MY_COMMITS)
    fun loadCommits(@Path(value = "name") name: String): Call<MutableList<Commit>>

}