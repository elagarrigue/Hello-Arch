package com.android.ejercicios.helloarch.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.ejercicios.helloarch.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel = UserListViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView.layoutManager = LinearLayoutManager(this)

        viewModel.observeUsers {
            listView.adapter = UserItemAdapter(it)
        }
    }
}
