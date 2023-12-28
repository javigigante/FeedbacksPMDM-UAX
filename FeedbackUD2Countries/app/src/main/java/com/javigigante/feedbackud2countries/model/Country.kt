package com.javigigante.feedbackud2countries.model

import java.io.Serializable

class Country (var countryName: String, var population: Double, var img: String) : Serializable{

    override fun toString(): String {
        return countryName
    }
}