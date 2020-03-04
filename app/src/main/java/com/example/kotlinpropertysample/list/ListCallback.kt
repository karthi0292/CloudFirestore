package com.example.kotlinpropertysample.list

interface ListCallback {
    fun onSuccess(completed:Boolean, list: ArrayList<*>)

    fun onFailure(errorMessage:String)
}