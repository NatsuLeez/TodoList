package com.example.todolist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.ui.theme.TodoListTheme

class MainActivity : AppCompatActivity() {

    private lateinit var addButton: Button
    private lateinit var myTextView: TextView
    lateinit var todoList: MutableList<Todo>
    private lateinit var Todorv: RecyclerView
    private lateinit var myEditText: TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Todorv = findViewById(R.id.rvTodos)
        addButton = findViewById(R.id.button)
        myEditText = findViewById(R.id.editText)

        todoList = mutableListOf(
            Todo("Wake up", false),
            Todo("Learn about RecyclerView", false),
            Todo("Feed my cat", false),
            Todo("Prank my boss", false),
            Todo("Eat some breakfast", false),
        )

        val adapter = TodoAdapter(todoList)
        Todorv.adapter = adapter
        Todorv.layoutManager = LinearLayoutManager(this)

        addButton.setOnClickListener {
            val title = myEditText.text.toString()
            val todo = Todo(title, false)
            if (title == ""){
                println("y a r")
            } else {
                todoList.add(todo)
            }
            adapter.notifyItemInserted(todoList.size - 1)
            adapter.removeCheckedItems()
        }


    }

}

