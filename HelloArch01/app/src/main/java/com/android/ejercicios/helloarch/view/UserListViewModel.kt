package com.android.ejercicios.helloarch.view

import com.android.ejercicios.helloarch.domain.User
import com.android.ejercicios.helloarch.repository.UsersRepository

class UserListViewModel {

    private val usersRepository = UsersRepository()

    fun observeUsers(callback: (List<User>) -> Unit) {
        usersRepository.observeUsers(callback)
    }
}