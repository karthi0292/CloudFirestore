package com.example.kotlinpropertysample.home.ui

import com.example.kotlinpropertysample.home.model.Employee

interface HomeContract {
    interface View{
         fun setPresenter(homePresenter: HomePresenter)
         fun isInserted(b: Boolean)
    }

    interface Presenter{
        fun insertEmployeeDetail(employee: Employee)
    }
}