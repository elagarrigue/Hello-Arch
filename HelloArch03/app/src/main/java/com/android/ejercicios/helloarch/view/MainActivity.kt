package com.android.ejercicios.helloarch.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.ejercicios.helloarch.R
import com.android.ejercicios.helloarch.domain.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView.layoutManager = LinearLayoutManager(this)

        val model = ViewModelProviders.of(this).get(UserListViewModel::class.java)
        model.observeUsers().observe(this,
            Observer<List<User>> {
                listView.adapter = UserItemAdapter(it)
            }
        )

    }
}
