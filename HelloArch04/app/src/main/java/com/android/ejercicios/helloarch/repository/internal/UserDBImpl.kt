package com.android.ejercicios.helloarch.repository.internal

import android.content.Context

class UserDBImpl constructor(context: Context) : UserDB {

    private var db = AppDatabase.getInstance(context)

    override fun insertAll(users: List<UserEntity>) {
        db.userDao().insertAll(users)
    }

    override fun getAll(): List<UserEntity> =
        db.userDao().getAll()

}