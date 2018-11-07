package com.android.ejercicios.helloarch.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.ejercicios.helloarch.domain.User

private const val REQUEST_SIZE = 500

class UsersRepository {

    private val api = UiNamesAPI()
    private val users: MutableLiveData<List<User>> = MutableLiveData()

    fun observeUsers(): LiveData<List<User>> {
        api.getUiNames(REQUEST_SIZE,
            { arrayOfUsers ->
                users.value = arrayOfUsers.asList()
            },
            { throw it }
        )
        return users
    }
}