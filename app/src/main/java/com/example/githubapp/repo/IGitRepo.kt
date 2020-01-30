package com.example.githubapp.repo

import com.example.githubapp.data.Model
import com.example.githubapp.data.commit.Commit
import retrofit2.Call

interface IGitRepo {
    fun loadAllRepos(): Call<MutableList<Model>>

    fun loadAllCommits(name:String):Call<MutableList<Commit>>
}