package com.android.ejercicios.helloarch.repository.internal

import android.content.Context

class UserDb constructor(context: Context) {

    private var db = AppDatabase.getInstance(context)

    fun insertAll(users: List<UserEntity>) {
        db.userDao().insertAll(users)
    }

    fun getAll(): List<UserEntity> =
        db.userDao().getAll()

}