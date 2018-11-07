package com.android.ejercicios.helloarch.repository.internal

interface UserDB{

    fun insertAll(users: List<UserEntity>)

    fun getAll(): List<UserEntity>
}