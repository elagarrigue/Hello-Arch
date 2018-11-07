package com.android.ejercicios.helloarch.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.ejercicios.helloarch.domain.User
import com.android.ejercicios.helloarch.repository.external.UiNamesAPI
import com.android.ejercicios.helloarch.repository.internal.UserDb
import com.android.ejercicios.helloarch.repository.internal.UserEntity
import kotlinx.coroutines.*

private const val REQUEST_SIZE = 500

class UsersRepository constructor(context: Context) {

    private val api: UiNamesAPI = UiNamesAPI()
    private val db: UserDb = UserDb(context)

    private val users: MutableLiveData<List<User>> = MutableLiveData()

    fun observeUsers(): LiveData<List<User>> {
        GlobalScope.launch {
            val savedUsers = getSavedUsers()
            when {
                savedUsers.isEmpty() -> getRemoteAndSaveUsers()
                else -> postUsers(savedUsers)
            }
        }
        return users
    }

    private fun postUsers(savedUsers: List<User>) {
        GlobalScope.launch(Dispatchers.Main) {
            users.value = savedUsers
        }
    }

    private fun getSavedUsers() =
        db.getAll()
            .map {
                User(it.email, it.name ?: "", it.age, it.photo ?: "", it.region ?: "")
            }

    private fun getRemoteAndSaveUsers() {
        val listOfUsers = getRemoteUsers()

        postUsers(listOfUsers)

        saveUsers(listOfUsers)
    }

    private fun getRemoteUsers() = api.getUiNames(REQUEST_SIZE).asList()

    private fun saveUsers(listOfUsers: List<User>) {
        db.insertAll(
            listOfUsers
                .map {
                    UserEntity(it.email, it.name, it.age, it.photo, it.region)
                })
    }
}