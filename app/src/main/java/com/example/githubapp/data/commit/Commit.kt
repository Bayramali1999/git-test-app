package com.example.githubapp.data.commit

data class Commit(
    val author: Author,
    val comments_url: String,
    val commit: CommitX,
    val committer: CommitterX,
    val html_url: String,
    val node_id: String,
    val parents: List<Parent>,
    val sha: String,
    val url: String
)