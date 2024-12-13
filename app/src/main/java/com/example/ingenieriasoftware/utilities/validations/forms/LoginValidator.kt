package com.example.ingenieriasoftware.utilities.validations.forms

import com.example.ingenieriasoftware.utilities.validations.data.PasswordValidator
import com.example.ingenieriasoftware.utilities.validations.data.UsernameValidator

class LoginValidator(
    private val username: String,
    private val password: String
) : FormValidator() {

    override fun checkFormat(): Boolean {
        if (UsernameValidator(username).isInvalid()) {
            message = "Usuario inválido"
            return false
        }
        if (PasswordValidator(password).isInvalid()) {
            message = "Contraseña inválida"
            return false
        }
        return true
    }

    override fun checkData(): Boolean {
        return true
    }

    override fun isValid(): Boolean {
        return checkFormat() && checkData()
    }
}