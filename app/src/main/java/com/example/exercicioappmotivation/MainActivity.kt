package com.example.exercicioappmotivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btnNovaPhrase:Button
    private lateinit var textUserName:TextView
    private lateinit var imageInfinity: ImageView
    private lateinit var imageHappy: ImageView
    private lateinit var imageSun: ImageView
    private lateinit var textMotivacionalPhrase: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNovaPhrase = findViewById(R.id.button_new_phrase)
        imageInfinity = findViewById(R.id.image_infinity)
        imageHappy = findViewById(R.id.image_happy)
        imageSun = findViewById(R.id.image_sun)
        textMotivacionalPhrase = findViewById(R.id.text_motivacional_phrase)
        textMotivacionalPhrase.text = PhrasesList().getPhrases(MotivationConstants.CATEGORY.all).toString()
        var categoryId: Int = 0

        handleUserName()


        textUserName.setOnClickListener{
            startActivity(Intent(this, UserActivity::class.java))
            SharedName(this).clearName()
        }

        imageInfinity.setOnClickListener {
            handleImageColor(imageInfinity)
            categoryId = MotivationConstants.CATEGORY.all
        }

        imageHappy.setOnClickListener {
            handleImageColor(imageHappy)
            categoryId = MotivationConstants.CATEGORY.happy
        }

        imageSun.setOnClickListener {
            handleImageColor(imageSun)
            categoryId = MotivationConstants.CATEGORY.sun
        }

        btnNovaPhrase.setOnClickListener {
            if (categoryId > 0){
                textMotivacionalPhrase.text = PhrasesList().getPhrases(categoryId).toString()
            }else{
                Toast.makeText(this, "Marque a categoria desejada!", Toast.LENGTH_SHORT).show()
            }

        }

    }

    private fun handleImageColor(id: ImageView){
        imageInfinity.setColorFilter(ContextCompat.getColor(this, R.color.grey_handle_ic_color))
        imageSun.setColorFilter(ContextCompat.getColor(this, R.color.grey_handle_ic_color))
        imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.grey_handle_ic_color))
        id.setColorFilter(ContextCompat.getColor(this, R.color.white))

    }

    private fun handleUserName(){
        textUserName = findViewById(R.id.text_hello_user)
        textUserName.text = String.format(getString(R.string.ola_), SharedName(this).getString(MotivationConstants.KEY.userName), "!")
    }

}