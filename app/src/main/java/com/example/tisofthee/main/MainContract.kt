package com.example.tisofthee.main

//Defines the contract between the View MainActivity and the Presenter

interface MainContract {
    interface Presenter : BasePresenter {
        fun attachView(view: View)
        fun onViewCreated()
        fun getResults()

    }

    interface View : BaseView<Presenter> {

        fun getCountryCode()
    }

    interface CallbackInterface {
        fun setCountryCode(message : String)
    }
}