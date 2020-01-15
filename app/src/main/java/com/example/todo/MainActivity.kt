package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    val listView = theActivity.findViewById<ListView>(R.id.list_view)
    listView.adapter = ArrayAdapter<ToDo>(
        aContext,
        android.R.layout.simple_list_item_1,
        android.R.id.text1,
        toDoRepository.getAllToDos()
    )
}
