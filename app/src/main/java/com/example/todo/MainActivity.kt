package com.example.todo

import android.app.SearchManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = this.findViewById<Button>(R.id.create_button)

        button.setOnClickListener {
            val intent = Intent(this,CreateToDoActivity::class.java)
            startActivity(intent)
            //this.finish()
        }

    }

    override fun onStart() {
        super.onStart()

        val listView = this.findViewById<ListView>(R.id.todo_list_view)

        listView.adapter = ArrayAdapter<ToDo>(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            toDoRepository.getAllToDos()

        )


        listView.setOnItemClickListener { parent, _, position, _ ->
            //val element = parent.getItemAtPosition(position)


            val todo = toDoRepository.getToDoById(position+1)

            val intent = Intent(this, ViewToDoActivity::class.java)
            println(todo?.id)

            intent.putExtra("content", todo?.content)
            intent.putExtra("title", todo?.title)
            intent.putExtra("id", todo?.id)
            startActivity(intent)
        }
    }



}
