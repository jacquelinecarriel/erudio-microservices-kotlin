package br.com.erudio.model

import org.springframework.stereotype.Service

data class Person (
    var id: Long = 0,
    var firstName: String = "Branquinho",
    var lastName: String = "Cabron",
    var addressName: String = "casa",
    var gender: String = "gatito"
)