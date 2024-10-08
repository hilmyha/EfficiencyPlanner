package com.example.efficiencyplanner.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.efficiencyplanner.Model.Service
import com.example.efficiencyplanner.Model.TaskList
import com.example.efficiencyplanner.R
import com.example.efficiencyplanner.TaskList.DetailTaskListActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class TaskListAdapter(
  private val taskListList: ArrayList<TaskList>,
  private val context: Context,
) : RecyclerView.Adapter<TaskListAdapter.ViewHolder>() {

  private val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("task_lists")

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(context).inflate(R.layout.task_list_item, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    // ambil data dari list taskList
    val taskList = taskListList[position]
    holder.taskListName.text = taskList.name

    holder.itemView.setOnClickListener() {
      val intent = Intent(context, DetailTaskListActivity::class.java).apply {
        putExtra("taskListId", taskList.id)
        putExtra("taskListName", taskList.name)
      }
      context.startActivity(intent)
    }
  }

  override fun getItemCount(): Int {
    return taskListList.size
  }

  inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val taskListName: TextView = itemView.findViewById(R.id.task_list_name)
  }
}