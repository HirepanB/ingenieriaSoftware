package com.example.ingenieriasoftware.utilities.validations.data

class PasswordValidator(content: String?) : DataValidator<String>(content) {
    override fun isInvalid(): Boolean {
        return content.isNullOrBlank()
    }
}