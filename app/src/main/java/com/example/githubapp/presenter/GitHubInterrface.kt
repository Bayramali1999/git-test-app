package com.example.githubapp.presenter

import com.example.githubapp.data.Model

interface GitHubInterrface {
    interface Presenter {
        fun loadAllRepos()
    }

    interface View {
        fun loadAllRepos(list: MutableList<Model>)
    }
}