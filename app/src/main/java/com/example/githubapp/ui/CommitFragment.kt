package com.example.githubapp.ui

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.githubapp.R
import com.example.githubapp.data.commit.Commit
import kotlinx.android.synthetic.main.fragment_home.*

class CommitFragment : Fragment(R.layout.fragment_home) {


    fun getList(commits: MutableList<Commit>) {

        val heshs = mutableListOf<String>()

        commits.forEach {
            heshs.add("#${it.sha.substring(17)}...")
        }

        spinner.adapter =
            ArrayAdapter<String>(
                activity!!,
                android.R.layout.simple_list_item_1, heshs
            )

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }
        }
    }

}