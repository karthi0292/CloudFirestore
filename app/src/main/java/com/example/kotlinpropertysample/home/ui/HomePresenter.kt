package com.example.kotlinpropertysample.home.ui

import android.content.Context
import com.example.kotlinpropertysample.FirebaseDBHelper
import com.example.kotlinpropertysample.FirebaseDBHelper.Companion.KEY_DOB
import com.example.kotlinpropertysample.FirebaseDBHelper.Companion.KEY_LAST_NAME
import com.example.kotlinpropertysample.FirebaseDBHelper.Companion.KEY_MIDDLE_NAME
import com.example.kotlinpropertysample.home.model.Employee

class HomePresenter(context: Context,view:HomeContract.View ):HomeContract.Presenter {
    private var firebaseDBHelper:FirebaseDBHelper
    private var context:Context
    private var view:HomeContract.View

    init {
        this.context=context
        this.view=view
        firebaseDBHelper=FirebaseDBHelper()
        view.setPresenter(this)
    }

    override fun insertEmployeeDetail(employee: Employee) {
        val user = hashMapOf(
            FirebaseDBHelper.KEY_FIRST_NAME to employee.firstName,
            KEY_LAST_NAME to employee.lastName,
            KEY_MIDDLE_NAME to employee.middleName,
            KEY_DOB to employee.dob)

        firebaseDBHelper.insertValues(user, object:Callback{
            override fun onSuccess(completed: Boolean, list: ArrayList<String>) {
                view.isInserted(true)
            }

            override fun onFailure(errorMessage: String) {
                view.isInserted(false)

            }

        })

    }
}