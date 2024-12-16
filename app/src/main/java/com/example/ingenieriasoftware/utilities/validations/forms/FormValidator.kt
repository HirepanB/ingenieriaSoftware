package com.example.ingenieriasoftware.utilities.validations.forms

abstract class FormValidator {
    val USERNAME_REGEX = "[a-zA-ZñÑ0-9]{3,32}".toRegex()
    val PASSWORD_REGEX = ".{5,32}".toRegex()
    val EMAIL_REGEX = "[^@]+@[^\\s@]+\\.[^\\s@]+".toRegex()
    val PHONE_REGEX = "[0-9]{8,10}".toRegex()

    var message: String = ""
    abstract fun checkFormat() : Boolean
    abstract fun checkData() : Boolean
    fun isValid() : Boolean {
        return checkFormat() && checkData()
    }
}