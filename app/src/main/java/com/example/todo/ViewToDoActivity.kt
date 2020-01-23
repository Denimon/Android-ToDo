package com.example.todo


import android.app.AlertDialog
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


        val id = intent.getIntExtra("id",-1)

        val titleTextField = this.findViewById<TextView>(R.id.title_textview)
        val contentTextField = this.findViewById<TextView>(R.id.content_textview)
        val updateButton = this.findViewById<Button>(R.id.update_button)
        val deleteButton = this.findViewById<Button>(R.id.delete_button)

        if (id == -1){
            titleTextField.setText(getString(R.string.idError))
            updateButton.isClickable = false
            deleteButton.isClickable = false
            //startActivity(Intent(this, MainActivity::class.java))
            //disable buttons?

        }
        else{

            val todo = toDoRepository.getToDoById(id)
            titleTextField.setText(todo?.title)
            contentTextField.setText(todo?.content)
        }


        updateButton.setOnClickListener {
            val intent = Intent(this, UpdateToDoActivity::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
            finish()
        }

        deleteButton.setOnClickListener {

            AlertDialog.Builder(this)
                .setTitle(getString(R.string.deleteToDo))
                .setMessage(getString(R.string.validateDelete))
                .setPositiveButton(
                    getString(R.string.yes)
                ) { dialog, whichButton ->

                    toDoRepository.deleteToDoById(id)
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()

                }.setNegativeButton(
                    getString(R.string.no)
                ) { dialog, whichButton ->

                    // Do not delete it.
                }.show()

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this,MainActivity::class.java))
    }
}