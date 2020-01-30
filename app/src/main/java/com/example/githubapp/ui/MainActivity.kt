package com.example.githubapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.githubapp.R
import com.example.githubapp.adapter.RepoAdapter
import com.example.githubapp.data.Model
import com.example.githubapp.presenter.GitHubInterfaceImpl
import com.example.githubapp.presenter.GitHubInterrface
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), GitHubInterrface.View {

    private val list = mutableListOf<Model>()
    private lateinit var appBarConfiguration: AppBarConfiguration
    private val adapter by lazy(LazyThreadSafetyMode.NONE)
    { RepoAdapter(this, list) }

    private var presenter: GitHubInterfaceImpl? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        presenter = GitHubInterfaceImpl(this)
        presenter?.loadAllRepos()

        rv_repos.adapter = adapter

        setUpNavView()
    }


    private fun setUpNavView() {
        val navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.nav_home), drawer_layout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        nav_view.setupWithNavController(navController)


    }

    override fun loadAllRepos(l: MutableList<Model>) {
        list.clear()
        list.addAll(l)
        adapter.notifyItemRangeInserted(0, l.size)
    }

}
