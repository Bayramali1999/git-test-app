package com.example.githubapp.repo

import com.example.githubapp.api.GitApi

class GitRepoImpl(private val api: GitApi) : IGitRepo {

    override fun loadAllRepos() = api.loadAllRepos()

    override fun loadAllCommits(name: String) = api.loadCommits(name)


}