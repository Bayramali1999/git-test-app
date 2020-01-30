package com.example.githubapp.presenter

import com.example.githubapp.data.Model
import com.example.githubapp.provide.Provides
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitHubInterfaceImpl(
    val view: GitHubInterrface.View
) : GitHubInterrface.Presenter {

    val repository = Provides.repoInstance()

    override fun loadAllRepos() {

        repository.loadAllRepos().enqueue(object : Callback<MutableList<Model>> {
            override fun onFailure(call: Call<MutableList<Model>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<MutableList<Model>>,
                response: Response<MutableList<Model>>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        view.loadAllRepos(body)
                    }
                }
            }

        })
    }

}