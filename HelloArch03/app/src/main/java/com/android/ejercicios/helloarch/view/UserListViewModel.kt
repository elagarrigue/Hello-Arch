package com.android.ejercicios.helloarch.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.android.ejercicios.helloarch.domain.User
import com.android.ejercicios.helloarch.repository.UsersRepository

class UserListViewModel(application: Application) : AndroidViewModel(application) {

    private val usersRepository = UsersRepository(application)

    private lateinit var users: LiveData<List<User>>

    fun observeUsers(): LiveData<List<User>> {
        if (!::users.isInitialized) {
            users = usersRepository.observeUsers()
        }
        return users
    }
}