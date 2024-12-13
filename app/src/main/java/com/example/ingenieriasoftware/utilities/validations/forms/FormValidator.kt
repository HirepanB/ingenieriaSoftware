package com.example.ingenieriasoftware.utilities.validations.forms

abstract class FormValidator {
    var message: String = ""
    abstract fun checkFormat() : Boolean
    abstract fun checkData() : Boolean
    abstract fun isValid() : Boolean
}