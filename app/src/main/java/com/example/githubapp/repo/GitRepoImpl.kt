package com.example.githubapp.repo

import com.example.githubapp.api.GitApi

class GitRepoImpl(val api: GitApi) : IGitRepo {

    override fun loadAllRepos() = api.loadAllRepos()
}