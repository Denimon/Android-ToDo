package com.example.todo


import android.app.SearchManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_viewtodo.*

class ViewToDoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewtodo)

        var content: String = intent.getStringExtra("content")
        var title: String = intent.getStringExtra("title")
        var idd: Int = intent.getIntExtra("id", 0)
        println(idd)

        val titleTextField = this.findViewById<TextView>(R.id.title_textview)
        val contentTextField = this.findViewById<TextView>(R.id.content_textview)
        titleTextField.setText(title)
        contentTextField.setText(content)
    }

}