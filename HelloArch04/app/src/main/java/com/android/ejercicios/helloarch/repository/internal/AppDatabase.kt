package com.android.ejercicios.helloarch.repository.internal

import android.content.Context
import androidx.room.RoomDatabase
import androidx.room.Database
import androidx.room.Room

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        fun getInstance(context: Context): AppDatabase {
            return Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java, "appDb")
                .build()
        }
    }
}
