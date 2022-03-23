package com.example.tisofthee.main

import java.io.Serializable

class CountryInfo (
        var name : String = "",
        var native : String = "",
        var phone : String = "",
        var continent : String = "",
        var capital : String = "",
        var currency : String = "",
        var languages : String = "",
        var emoji : String = ""
    ) : Serializable
