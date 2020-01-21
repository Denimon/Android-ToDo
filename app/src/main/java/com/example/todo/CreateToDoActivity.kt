package com.example.todo



import android.app.SearchManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class CreateToDoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createtodo)

        val createButton = this.findViewById<Button>(R.id.create_todo_button)
        val titleInput = this.findViewById<EditText>(R.id.title_text_input)
        val descriptionInput = this.findViewById<EditText>(R.id.description_text_input)

        createButton.setOnClickListener {

            val title = titleInput.editableText.toString()
            val description = descriptionInput.editableText.toString()

            toDoRepository.addToDo(title,description)
            val intent = Intent(this, ViewToDoActivity::class.java)

            intent.putExtra("content", description)
            intent.putExtra("title", title)
            startActivity(intent)
            finish()

        }
    }
}