package com.android.ejercicios.helloarch.repository

import com.android.ejercicios.helloarch.domain.User

private const val REQUEST_SIZE = 500

class UsersRepository {

    private val api: UiNamesAPI = UiNamesAPI()

    fun observeUsers(callback: (List<User>) -> Unit) {
        api.getUiNames(
            REQUEST_SIZE,
            { arrayOfUsers -> callback(arrayOfUsers.asList()) },
            { throw it }
        )
    }
}