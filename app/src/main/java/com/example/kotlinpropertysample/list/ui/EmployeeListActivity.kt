package com.example.kotlinpropertysample.list.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinpropertysample.R
import com.example.kotlinpropertysample.list.EmployeeRvAdapter
import kotlinx.android.synthetic.main.activity_customer_detail.*

class EmployeeListActivity : AppCompatActivity(),
    EmployeeListContract.View {

    private lateinit var presenter: EmployeeListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_detail)

        EmployeeListPresenter(this,this)

        presenter.fetchAllData()

    }

    override fun setPresenter(presenter: EmployeeListPresenter) {
        this.presenter = presenter
    }

    override fun setEmployeeData(list: ArrayList<*>) {
        val adapter=EmployeeRvAdapter(this,list)

        val loutManager=LinearLayoutManager(this)
        loutManager.orientation=LinearLayoutManager.VERTICAL
        act_cus_detail_rv.layoutManager=loutManager

        act_cus_detail_rv.adapter=adapter

    }
}
