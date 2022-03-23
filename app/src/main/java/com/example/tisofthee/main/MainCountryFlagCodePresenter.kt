package com.example.tisofthee.main

//Note to self - responsible for handling actions from the View and updating the UI

class MainCountryFlagCodePresenter(view: MainContract.View) : MainContract.Presenter {
    private var view: MainContract.View? = view


    override fun attachView(view: MainContract.View) {
        TODO("Not yet implemented")
    }

    override fun onViewCreated() {
       // loadCountries()
    }

    override fun getResults() {

    }


    override fun onDestroy() {
        this.view = null
    }

}