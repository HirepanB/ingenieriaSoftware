package com.example.ingenieriasoftware.utilities.validations.data

class UsernameValidator(content: String?) : DataValidator<String>(content) {
    override fun isInvalid(): Boolean {
        return content.isNullOrBlank()
    }
}