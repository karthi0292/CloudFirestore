package com.example.kotlinpropertysample.home.ui

interface Callback {
    fun onSuccess(completed:Boolean, list: ArrayList<String>)

    fun onFailure(errorMessage:String)
}