package com.android.ejercicios.helloarch.repository.external

import com.android.ejercicios.helloarch.domain.User

interface UsersService {
    fun getUiNames(amount: Int): Array<User>
}