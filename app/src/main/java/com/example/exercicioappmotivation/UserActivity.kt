package com.example.exercicioappmotivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class UserActivity : AppCompatActivity() {

    private lateinit var btnSave:Button
    private lateinit var editTxtName:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        verifyUserName()

        btnSave = findViewById(R.id.button_save)
        editTxtName = findViewById(R.id.edit_name)

        btnSave.setOnClickListener {
            handleSave()
        }

    }

    private fun handleSave(){
        var nome:String = ""
        if (editTxtName.text.isNullOrEmpty()){
            editTxtName.error = "Digite seu nome!"
        } else{
            nome = editTxtName.text.toString()
            SharedName(this).storeString(MotivationConstants.KEY.userName, nome)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun verifyUserName(){
        val name = SharedName(this).getString(MotivationConstants.KEY.userName)
        if (name != ""){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

}