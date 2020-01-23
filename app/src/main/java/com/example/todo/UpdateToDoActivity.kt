package com.example.todo


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class UpdateToDoActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_updatetodo)

        val saveButton = this.findViewById<Button>(R.id.save_todo_button)
        val descriptionInput = this.findViewById<EditText>(R.id.description_input_edit_text)
        val titleInput = this.findViewById<EditText>(R.id.title_input_edit_text)

        val id = intent.getIntExtra("id",-1)


        if(id == -1){

            //error
            println("id error")
        }
        else{

            val toDo = toDoRepository.getToDoById(id)
            descriptionInput.setText(toDo?.content)
            titleInput.setText(toDo?.title)
        }

        saveButton.setOnClickListener {

            val title = titleInput.editableText.toString()
            val description = descriptionInput.editableText.toString()

            if (validateDescriptionInput(description) && validateTitleInput(title)){

                toDoRepository.updateToDoById(id,title,description)

                val intent = Intent(this, ViewToDoActivity::class.java)
                intent.putExtra("id",id)
                startActivity(intent)
                finish()

            }
            else{

                if(title.length < 3 || title.length > 15){
                    titleInput.setError(getString(R.string.titleError))
                    //titleInput.setError("Title must be min 3 and max 15 character")
                }
                if(description.length <3 || description.length > 50){
                    descriptionInput.setError(getString(R.string.descriptionError))
                }
            }
        }
    }
}