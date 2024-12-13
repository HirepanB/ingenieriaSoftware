package com.example.ingenieriasoftware.utilities.validations.data

abstract class DataValidator<T>(val content: T?) {
    abstract fun isInvalid(): Boolean
}