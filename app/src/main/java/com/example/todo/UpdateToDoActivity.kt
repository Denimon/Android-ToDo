package com.example.todo


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class UpdateToDoActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_updatetodo)

        val updateButton = this.findViewById<Button>(R.id.update_todo_button)
        val desc = this.findViewById<EditText>(R.id.description_input_edit_text)
        val title = this.findViewById<EditText>(R.id.title_input_edit_text)


        updateButton.setOnClickListener {
            println(desc.editableText.toString())
            println(title.editableText.toString())
        }


    }



}