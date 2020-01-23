package com.example.todo



import android.app.SearchManager
import android.content.ClipDescription
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


public fun validateTitleInput(title: String) = (title.length > 3 && title.length < 16)

public fun validateDescriptionInput(description: String) = (description.length > 3 && description.length < 51)

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

            if (validateTitleInput(title) && validateDescriptionInput(description)) {

                val newTodoId = toDoRepository.addToDo(title,description)
                val intent = Intent(this, ViewToDoActivity::class.java)

                intent.putExtra("id",newTodoId)
                startActivity(intent)
                finish()
            }
            else{

                if(title.length < 3 || title.length > 15){
                    titleInput.setError(getString(R.string.titleError))
                }
                if(description.length < 3 || description.length > 50){
                    descriptionInput.setError(getString(R.string.descriptionError))
                }
            }
        }
    }
}