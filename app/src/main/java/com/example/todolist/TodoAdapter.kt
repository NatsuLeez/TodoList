package com.example.todolist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*


@SuppressLint("StaticFieldLeak")
lateinit var tvTitle: TextView
@SuppressLint("StaticFieldLeak")
lateinit var cbDone: CheckBox

class TodoAdapter(
    var todos: MutableList<Todo>,

) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {


    inner class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)

        return TodoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todos.size
    }



    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.itemView.apply {
            tvTitle = findViewById(R.id.tvTitle)
            cbDone = findViewById(R.id.cbDone)
            tvTitle.text = todos[position].title
            cbDone.isChecked = todos[position].isChecked

            cbDone.setOnCheckedChangeListener { _, isChecked ->
                todos[position].isChecked = isChecked

            }
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    fun removeCheckedItems() {
        val iterator = todos.iterator()
        while (iterator.hasNext()) {
            val todo = iterator.next()
            if (todo.isChecked) {
                iterator.remove()
            }
        }
        notifyDataSetChanged()
    }


}
