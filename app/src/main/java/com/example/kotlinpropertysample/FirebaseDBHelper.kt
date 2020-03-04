package com.example.kotlinpropertysample

import android.util.Log
import com.example.kotlinpropertysample.home.model.Employee
import com.example.kotlinpropertysample.home.ui.Callback
import com.example.kotlinpropertysample.list.ListCallback
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseDBHelper() {
    companion object{
        val KEY_FIRST_NAME = "first"
        val KEY_LAST_NAME = "last"
        val KEY_MIDDLE_NAME = "middle"
        val KEY_DOB = "dob"
    }

    private val TAG = FirebaseDBHelper::class.java.name
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    fun insertValues(
        user: HashMap<String, String>,
        callback: Callback
    ) {
        db.collection("users").add(user).addOnSuccessListener { documentReference ->
            Log.d(TAG, "Document Created with ID $documentReference.id")
            var ar = ArrayList<String>()
            callback.onSuccess(true, ar)
        }.addOnFailureListener { exception ->
            Log.d(TAG, "Error adding document", exception)
        }
    }

    fun getValues(callback: ListCallback) {
        db.collection("users").get().addOnSuccessListener { result ->
            var employeeList=ArrayList<Employee>()

            for (document in result) {
                var employee=Employee(
                    document.get(KEY_FIRST_NAME) as String,
                    document.get(KEY_LAST_NAME) as String,
                    document.get(KEY_MIDDLE_NAME) as String,
                    document.get(KEY_DOB) as String)

                employeeList.add(employee)
                callback.onSuccess(true,employeeList)
            }

        }.addOnFailureListener { exception ->
            Log.d(TAG, "Error Getting documents", exception)
        }
    }
}