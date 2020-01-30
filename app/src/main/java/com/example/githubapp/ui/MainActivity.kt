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
import com.example.githubapp.adapter.listener.OnItemClickListener
import com.example.githubapp.data.Model
import com.example.githubapp.data.commit.Commit
import com.example.githubapp.presenter.GitHubInterface
import com.example.githubapp.presenter.GitHubInterfaceImpl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), GitHubInterface.View, OnItemClickListener {

    private var fragment: CommitFragment? = null
    private val list = mutableListOf<Model>()
    private lateinit var appBarConfiguration: AppBarConfiguration
    private val adapter by lazy(LazyThreadSafetyMode.NONE)
    { RepoAdapter(this, list) }

    private var presenter: GitHubInterfaceImpl? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fragment = CommitFragment()
        presenter = GitHubInterfaceImpl(this)
        presenter?.loadAllRepos()

        rv_repos.adapter = adapter

        setUpNavView()
        setUpFragment()
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

    override fun loadAllRepos(myList: MutableList<Model>) {
        list.clear()
        list.addAll(myList)
        adapter.notifyItemRangeInserted(0, myList.size)
    }

    override fun loadAllCommits(commits: MutableList<Commit>) {
        //TODO() loaded all commits

        fragment?.getList(commits)
    }

    override fun onItemClicked(name: String) {
        presenter?.loadAllCommits(name)
        drawer_layout.closeDrawers()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
