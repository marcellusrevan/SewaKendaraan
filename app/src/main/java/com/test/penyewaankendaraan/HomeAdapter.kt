package com.test.penyewaankendaraan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.penyewaankendaraan.databinding.RecyclerviewItemBinding

class HomeAdapter(val taskList: List<Task>):RecyclerView.Adapter<HomeAdapter.MainViewHolder>() {
    inner class MainViewHolder(val itemBinding: RecyclerviewItemBinding)
        :RecyclerView.ViewHolder(itemBinding.root){
        fun bindItem(task:Task){
            itemBinding.chapter.text = task.chapter
            itemBinding.itemTitle.text = task.title
            itemBinding.itemDetail.text = task.details
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val task = taskList[position]
        holder.bindItem(task)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
}