package com.example.miras.todoapp

import org.koin.dsl.module.module

val todoApp = module {

    factory { TodoListPresenter(get()) as TodoListContract.Presenter}

    single { TodoRepository(get(), get()) as TodoListContract.Repository}

}