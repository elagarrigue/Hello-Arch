package com.android.ejercicios.helloarch.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.ejercicios.helloarch.domain.User
import com.android.ejercicios.helloarch.repository.external.UsersService
import com.android.ejercicios.helloarch.repository.internal.UserDB
import com.android.ejercicios.helloarch.repository.internal.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

private const val REQUEST_SIZE = 500

class UsersRepositoryImpl constructor(
    private val api: UsersService,
    private val db: UserDB
) : UsersRepository {
    private val users: MutableLiveData<List<User>> = MutableLiveData()

    override fun observeUsers(): LiveData<List<User>> {
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