package com.example.githubapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.githubapp.R
import com.example.githubapp.adapter.RepoAdapter
import com.example.githubapp.data.Model
import com.example.githubapp.data.commit.Commit
import com.example.githubapp.presenter.GitHubInterface
import com.example.githubapp.presenter.GitHubInterfaceImpl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.nav_header_main.*

class MainActivity : AppCompatActivity(), GitHubInterface.View {

    private var fragment: CommitFragment? = null
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var adapter: RepoAdapter

    private var presenter: GitHubInterfaceImpl? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        init()

        setUpNavView()
        setUpFragment()
    }

    private fun init() {
        fragment = CommitFragment()
        presenter = GitHubInterfaceImpl(this)
        presenter?.loadAllRepos()
    }

    private fun setUpFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment!!, "")
            .commit()
    }


    private fun setUpNavView() {
        val navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.nav_home), drawer_layout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        nav_view.setupWithNavController(navController)
    }

    override fun loadAllRepos(list: MutableList<Model>) {
        adapter = RepoAdapter(
            this,
            list
        ) { name ->
            presenter?.loadAllCommits(name)
            drawer_layout.closeDrawers()
        }


        rv_repos.adapter = adapter
    }

    override fun loadAllCommits(commits: MutableList<Commit>) {
        fragment?.getList(commits)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
