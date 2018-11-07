package com.android.ejercicios.helloarch.repository.internal

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM userentity")
    fun getAll(): List<UserEntity>

    @Query(
        "SELECT * FROM userentity WHERE name LIKE :first AND "
                + "region LIKE :last LIMIT 1"
    )
    fun findByName(first: String, last: String): UserEntity

   @Insert
    fun insertAll(users: List<UserEntity>)
}
