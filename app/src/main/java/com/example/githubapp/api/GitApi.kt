package com.example.githubapp.api

import com.example.githubapp.api.common.Constant
import com.example.githubapp.data.Model
import com.example.githubapp.data.commit.Commit
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitApi {
    @GET(Constant.MY_REPOS)
    fun loadAllRepos(): Call<MutableList<Model>>


    @GET("repos/Bayramali1999/{name}/commits")
    fun loadCommits(@Path(value = "name") name: String): Call<MutableList<Commit>>

}