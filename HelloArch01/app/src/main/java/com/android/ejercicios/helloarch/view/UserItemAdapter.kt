package com.android.ejercicios.helloarch.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.ejercicios.helloarch.R
import com.android.ejercicios.helloarch.domain.User
import com.squareup.picasso.Picasso

class UserItemAdapter(
    private val dataSet: List<User>
) : RecyclerView.Adapter<UserItemAdapter.UserViewHolder>() {

    class UserViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserItemAdapter.UserViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user_view, parent, false)

        return UserViewHolder(v)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val image = holder.view.findViewById<ImageView>(R.id.image)
        val title = holder.view.findViewById<TextView>(R.id.title)
        val subTitle = holder.view.findViewById<TextView>(R.id.subTitle)

        val user = dataSet[position]

        Picasso.get().load(user.photo).into(image)
        title.text = user.name
        subTitle.text = user.email
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}