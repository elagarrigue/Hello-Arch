package com.android.ejercicios.helloarch.repository

import androidx.lifecycle.LiveData
import com.android.ejercicios.helloarch.domain.User

interface UsersRepository  {

    fun observeUsers(): LiveData<List<User>>
}