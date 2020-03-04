package com.example.kotlinpropertysample.list.ui

interface EmployeeListContract {

    interface View {
        fun setPresenter(presenter: EmployeeListPresenter)
        fun setEmployeeData(list: ArrayList<*>)
    }

    interface Presenter {
        fun setLoading(message: String)
    }
}