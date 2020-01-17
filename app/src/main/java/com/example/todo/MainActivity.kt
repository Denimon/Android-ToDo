package com.example.todo

import android.app.SearchManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = this.findViewById<ListView>(R.id.list_view)


        listView.adapter = ArrayAdapter<ToDo>(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            toDoRepository.getAllToDos()
        )


        listView.setOnItemClickListener { parent, _, position, id ->
            val element = parent.getItemAtPosition(position)
            println(element)

            //val intent = Intent(this,CreateToDoActivity::class.java)
            val intent = Intent(this, ViewToDoActivity::class.java)
            startActivity(intent)
        }



    }
}
