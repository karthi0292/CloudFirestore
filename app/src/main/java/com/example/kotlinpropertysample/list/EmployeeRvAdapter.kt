package com.example.kotlinpropertysample.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinpropertysample.R
import com.example.kotlinpropertysample.home.model.Employee


class EmployeeRvAdapter(context: Context, list: ArrayList<*>)
    : RecyclerView.Adapter<EmployeeRvAdapter.CustomViewHolder>() {
    private val context: Context = context
    private val list: ArrayList<Employee> = list as ArrayList<Employee>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_employee, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        var employee:Employee=list.get(position)
        holder.tvName.setText((employee.firstName).plus(employee.middleName).plus(employee.lastName))
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView=itemView.findViewById(R.id.itemEmployee_tv_name)
    }
}