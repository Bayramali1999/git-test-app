package com.example.githubapp.provider

import com.example.githubapp.api.GitApi
import com.example.githubapp.api.common.Constant
import com.example.githubapp.repo.GitRepoImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface Provides {

    companion object {
        var apiInstance: GitApi? = null
        fun apiInstance(): GitApi {
            if (apiInstance == null) {
                val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Constant.BASE_URL)
                    .build()

                apiInstance = retrofit.create(GitApi::class.java)
            }
            return apiInstance!!
        }


        var repoInstance: GitRepoImpl? = null

        fun repoInstance(): GitRepoImpl {

            if (repoInstance == null) {
                val api =
                    apiInstance()
                repoInstance = GitRepoImpl(api)
            }
            return repoInstance!!
        }
    }

}