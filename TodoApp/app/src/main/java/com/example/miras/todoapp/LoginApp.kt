package com.example.miras.todoapp

import org.koin.dsl.module.module

val loginApp = module {


    factory { LoginPresenter(get()) as LoginContract.Presenter}

    single { LoginRepository(get(), get()) as LoginContract.Repository}

}