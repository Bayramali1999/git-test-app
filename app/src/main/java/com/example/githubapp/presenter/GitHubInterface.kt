package com.example.githubapp.presenter

import com.example.githubapp.data.Model
import com.example.githubapp.data.commit.Commit

interface GitHubInterface {
    interface Presenter {
        fun loadAllRepos()

        fun loadAllCommits(name:String)
    }

    interface View {
        fun loadAllRepos(list: MutableList<Model>)

        fun loadAllCommits(commits:MutableList<Commit>)
    }
}