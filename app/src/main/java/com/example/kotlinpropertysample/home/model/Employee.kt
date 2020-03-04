package com.example.kotlinpropertysample.home.model

class Employee(
    frstName: String,
    lstName: String,
    midName: String,
    dob: String
) {
    var firstName:String=""
    get()=field
    set(value){
        field=value
    }
    var lastName:String=""
    get() = field
    set(value) {
        field=value
    }

    var middleName:String=""
    get() = field
    set(value){
        field=value
    }

    var dob:String=""
    get() = field
    set(value) {
        field=value
    }

    init {
        this.firstName=frstName
        this.lastName=lstName
        this.middleName=midName
        this.dob=dob
    }

}