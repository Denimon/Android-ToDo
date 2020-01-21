package com.example.todo


import android.app.SearchManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_viewtodo.*

class ViewToDoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewtodo)

        var content: String = intent.getStringExtra("content")
        var title: String = intent.getStringExtra("title")
        var idd: Int = intent.getIntExtra("id", -1)
        println(idd)

        val titleTextField = this.findViewById<TextView>(R.id.title_textview)
        val contentTextField = this.findViewById<TextView>(R.id.content_textview)
        titleTextField.setText(title)
        contentTextField.setText(content)

        val updateButton = this.findViewById<Button>(R.id.update_button)
        val deleteButton = this.findViewById<Button>(R.id.delete_button)


        updateButton.setOnClickListener {
            val intent = Intent(this, UpdateToDoActivity::class.java)
            intent.putExtra("title", title)
            intent.putExtra("description",content)
            intent.putExtra("id", idd)

            startActivity(intent)

        }

        deleteButton.setOnClickListener {

            //show alert to user

        }
    }
}