package com.example.ingenieriasoftware.utilities.validations.forms

import okhttp3.*
import java.io.IOException
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import org.json.JSONObject

class RegisterValidator(
    private val username: String,
    private val email: String,
    private val phoneNumber: String,
    private val password: String,
    private val repeatPassword: String,
) : FormValidator() {

    val baseUrl = "http://192.168.100.139:5000"

    override fun checkFormat(): Boolean {
        if (!USERNAME_REGEX.matches(username)) {
            message = "Nombre de usuario inválido"
            return false
        }
        if (!EMAIL_REGEX.matches(email)) {
            message = "Email inválido"
            return false
        }
        if (!PHONE_REGEX.matches(phoneNumber)) {
            message = "Número inválido"
            return false
        }
        if (password != repeatPassword) {
            message = "Las contraseñas no coinciden"
            return false
        }
        if (!PASSWORD_REGEX.matches(password)) {
            message = "Contraseña inválida"
            return false
        }
        return true
    }

    override fun checkData(): Boolean {
        register(username, password) { response ->
            println("Register Response: $response")
        }
        return true
    }

    private fun register(username: String, password: String, callback: (String?) -> Unit) {
        val client = OkHttpClient()

        val json = JSONObject()
        json.put("username", username)
        json.put("password", password)

        val body = RequestBody.create("application/json".toMediaType(), json.toString())

        val request = Request.Builder()
            .url("$baseUrl/register")
            .post(body)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                callback("Error: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    callback(it.body?.string())
                }
            }
        })
    }
}