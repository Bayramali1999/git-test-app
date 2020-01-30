package com.example.githubapp.presenter

import android.util.Log
import com.example.githubapp.data.Model
import com.example.githubapp.data.commit.Commit
import com.example.githubapp.provider.Provides
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitHubInterfaceImpl(
    val view: GitHubInterface.View
) : GitHubInterface.Presenter {

   private val repository = Provides.repoInstance()

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

    override fun loadAllCommits(name: String) {
        repository.loadAllCommits(name).enqueue(object : Callback<MutableList<Commit>> {
            override fun onFailure(call: Call<MutableList<Commit>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<MutableList<Commit>>,
                response: Response<MutableList<Commit>>
            ) {
                Log.d("RESPONSE ", response.body().toString())
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        view.loadAllCommits(body)
                    }
                }
            }
        })
    }

}