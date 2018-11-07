package com.android.ejercicios.helloarch.repository

import com.android.ejercicios.helloarch.domain.User
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.google.gson.Gson

class UiNamesAPI {

    fun getUiNames(amount: Int, callback: (Array<User>) -> Unit, onError: (Error) -> Unit) {
        "https://uinames.com/api/?ext&amount=$amount"
            .httpGet()
            .responseString { _, _, result ->
                when (result) {
                    is Result.Failure -> {
                        onError(Error(result.getException()))
                    }
                    is Result.Success -> {
                        val users = Gson().fromJson(result.component1(), Array<User>::class.java)
                        callback(users)
                    }
                }
            }
    }
}