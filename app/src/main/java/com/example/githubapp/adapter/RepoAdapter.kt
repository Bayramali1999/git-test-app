package com.example.githubapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubapp.R
import com.example.githubapp.adapter.listener.OnItemClickListener
import com.example.githubapp.data.Model
import kotlinx.android.synthetic.main.item_view.view.*

class RepoAdapter(ctx: Context, private val list: MutableList<Model>) :
    RecyclerView.Adapter<RepoAdapter.RepoVH>() {

    private val listener = ctx as OnItemClickListener
    private val inflater by lazy(LazyThreadSafetyMode.NONE) { LayoutInflater.from(ctx) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoVH {
        val view = inflater.inflate(R.layout.item_view, parent, false)
        return RepoVH(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: RepoVH, position: Int) {
        val item = list[position]
        holder.onBind(item)
    }


    inner class RepoVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var repoName: String? = null
        init {
            itemView.setOnClickListener {
                listener.onItemClicked(repoName!!)
            }
        }
        fun onBind(item: Model) {
            itemView.tv_repo_name.text = item.name
            this.repoName = item.name
        }
    }

}