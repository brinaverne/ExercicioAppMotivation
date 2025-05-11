package com.example.exercicioappmotivation

import android.content.Context
import android.content.SharedPreferences

class SharedName(context: Context) {

    private val namePref: SharedPreferences = context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun getString(key: String): String{
        return namePref.getString(key, "") ?: ""
    }

    fun storeString(key: String, str: String){
        namePref.edit().putString(key, str).apply()
    }

    fun clearName(){
        namePref.edit().putString(MotivationConstants.KEY.userName, "").apply()
    }

}