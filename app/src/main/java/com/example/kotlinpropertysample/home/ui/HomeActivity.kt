package com.example.kotlinpropertysample.home.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kotlinpropertysample.R
import com.example.kotlinpropertysample.home.model.Employee
import com.example.kotlinpropertysample.list.ui.EmployeeListActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity(), View.OnClickListener,HomeContract.View {

    private lateinit var presenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_insert.setOnClickListener(this)

        HomePresenter(this,this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_insert -> {
                var frstName = edt_frst_name.text.toString().trim()
                var lstName = edt_last_name.text.toString().trim()
                var midName = edt_mid_name.text.toString().trim()
                var dob = edt_dob.text.toString().trim()

                if (validationOfInputs(
                        frstName,
                        lstName,
                        midName,
                        dob)){
                    val employee= Employee(frstName, lstName, midName, dob)
                    presenter.insertEmployeeDetail(employee)
                }
            }
        }
    }

    override fun setPresenter(homePresenter: HomePresenter) {
        presenter=homePresenter
    }

    override fun isInserted(b: Boolean) {
        Snackbar.make(root_lout,"Values are saved",Snackbar.LENGTH_LONG).show()

        val intent=Intent(this,EmployeeListActivity::class.java)
        startActivity(intent)

    }

    fun validationOfInputs(
        firstName: String,
        lastName: String,
        midName: String,
        dob: String): Boolean {
        if (firstName != null && !firstName.isEmpty())
            if (lastName != null && !lastName.isEmpty())
                if(dob != null && !dob.isEmpty())
                 return true
                else
                    Snackbar.make(root_lout, "Enter the dob", Snackbar.LENGTH_LONG).show()
            else
                Snackbar.make(root_lout, "Enter the lastname", Snackbar.LENGTH_LONG).show()
        else
            Snackbar.make(root_lout, "Enter the firstname", Snackbar.LENGTH_LONG).show()
        return false
    }
}
