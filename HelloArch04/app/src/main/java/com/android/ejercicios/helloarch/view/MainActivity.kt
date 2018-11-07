package com.android.ejercicios.helloarch.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.ejercicios.helloarch.R
import com.android.ejercicios.helloarch.domain.User
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val model: UserListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView.layoutManager = LinearLayoutManager(this)

        model.observeUsers().observe(this,
            Observer<List<User>> {
                listView.adapter = UserItemAdapter(it)
            }
        )
    }
}