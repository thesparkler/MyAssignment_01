package com.amitkumar.myapp.assignment.adapters

import com.amitkumar.myapp.assignment.database.UserItem


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amitkumar.myapp.assignment.R
import kotlinx.android.synthetic.main.shaadi_matches_layout.view.*


class UserDataAdapter(val items: List<UserItem>) :
    RecyclerView.Adapter<UserDataAdapter.ViewHolder>() {

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        p0.bind(items[p1])
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(p0!!.context)
        val row = layoutInflater.inflate(R.layout.shaadi_matches_layout, p0, false)

        return ViewHolder(row)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(userList: View) : RecyclerView.ViewHolder(userList) {

        val itemVw = userList

        fun bind(item: UserItem) {
            itemVw.titleTv.text = item.title.toString()
            itemVw.firstNameTV.text = item.first.toString()
            itemVw.lastNameTv.text = item.last.toString()
            itemVw.ageTv.text = item.age.toString()
            itemVw.nationalityTv.text = item.nat.toString()
            itemVw.setOnClickListener { }
        }
    }
}
