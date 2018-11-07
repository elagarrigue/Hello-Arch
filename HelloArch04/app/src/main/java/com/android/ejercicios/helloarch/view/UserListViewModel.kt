package com.android.ejercicios.helloarch.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.ejercicios.helloarch.domain.User
import com.android.ejercicios.helloarch.repository.UsersRepository

class UserListViewModel(
    private val usersRepository: UsersRepository
) : ViewModel() {

    private lateinit var users: LiveData<List<User>>

    fun observeUsers(): LiveData<List<User>> {
        if (!::users.isInitialized) {
            users = usersRepository.observeUsers()
        }
        return users
    }
}