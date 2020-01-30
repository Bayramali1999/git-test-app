package com.example.githubapp.api

import com.example.githubapp.api.common.Constant
import com.example.githubapp.data.Model
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GitApi {
    @GET(Constant.MY_USER_NAME)
    fun loadAllRepos(): Call<MutableList<Model>>



}