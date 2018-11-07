package com.android.ejercicios.helloarch.repository.internal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    var email: String = "",
    var name: String? = null,
    var age: Int = 0,
    var photo: String? = null,
    var region: String? = null
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}