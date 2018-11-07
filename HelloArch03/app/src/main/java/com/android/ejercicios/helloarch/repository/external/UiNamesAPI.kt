package com.android.ejercicios.helloarch.repository.external

import com.android.ejercicios.helloarch.domain.User
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.google.gson.Gson

class UiNamesAPI {

    fun getUiNames(amount: Int): Array<User> {
        val response = "https://uinames.com/api/?ext&amount=$amount"
            .httpGet()
            .responseString(Charsets.UTF_8)

        val result = response.third

        return when (result) {
            is Result.Failure -> {
                throw(Error(result.getException().message))
            }
            is Result.Success -> {
                Gson().fromJson(result.component1(), Array<User>::class.java)
            }
        }

    }
}