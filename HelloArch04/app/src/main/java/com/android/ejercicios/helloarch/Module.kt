package com.android.ejercicios.helloarch

import com.android.ejercicios.helloarch.repository.UsersRepository
import com.android.ejercicios.helloarch.repository.UsersRepositoryImpl
import com.android.ejercicios.helloarch.repository.external.UiNamesAPI
import com.android.ejercicios.helloarch.repository.external.UsersService
import com.android.ejercicios.helloarch.repository.internal.UserDB
import com.android.ejercicios.helloarch.repository.internal.UserDBImpl
import com.android.ejercicios.helloarch.view.UserListViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {

    viewModel { UserListViewModel(get()) }

    single<UsersService> { UiNamesAPI() }

    single<UserDB> { UserDBImpl(get()) }

    single<UsersRepository> { UsersRepositoryImpl(get(), get()) }
}