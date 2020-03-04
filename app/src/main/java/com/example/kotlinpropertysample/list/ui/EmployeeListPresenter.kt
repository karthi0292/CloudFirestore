package com.example.kotlinpropertysample.list.ui

import android.content.Context
import com.example.kotlinpropertysample.FirebaseDBHelper
import com.example.kotlinpropertysample.list.ListCallback

class EmployeeListPresenter(
    context: Context,
    view: EmployeeListContract.View) : EmployeeListContract {
    private var context: Context
    private var view: EmployeeListContract.View
    val firebaseDBHelper: FirebaseDBHelper

    init {
        this.view=view
        this.context=context
        firebaseDBHelper = FirebaseDBHelper()
        view.setPresenter(this)
    }

    fun fetchAllData() {
        firebaseDBHelper.getValues(object : ListCallback {
            override fun onSuccess(completed: Boolean, list: ArrayList<*>) {
                view.setEmployeeData(list)
            }

            override fun onFailure(errorMessage: String) {

            }
        })
    }
}