package com.example.tisofthee.main

interface BaseView<T> {
    fun setPresenter(presenter : T)
}