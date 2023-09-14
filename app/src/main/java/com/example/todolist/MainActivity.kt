package com.example.todolist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.ui.theme.TodoListTheme

class MainActivity : AppCompatActivity() {

    private lateinit var addButton: Button
    private lateinit var myTextView: TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataset = arrayOf("January", "February", "March")
        val customAdapter = CustomAdapter(dataset)

        val recyclerView: RecyclerView = findViewById(R.id.rvTodos)
        recyclerView.adapter = customAdapter
        addButton = findViewById(R.id.button)
        myTextView = findViewById(R.id.editText)



        addButton.setOnClickListener{
            //val entree = arrayOf(myTextView.toString())
            println(recyclerView.adapter)

        }

    }
}