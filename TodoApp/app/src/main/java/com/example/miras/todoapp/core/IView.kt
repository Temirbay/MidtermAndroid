package com.example.miras.todoapp.core



interface IView <out P : IPresenter<*>> {
    val presenter : P
}