package com.example.ingenieriasoftware.utilities.validations.forms

import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException


class LoginValidator(
    private val username: String,
    private val password: String
) : FormValidator() {

    val baseUrl = "http://localhost:5000"

    override fun checkFormat(): Boolean {
        if (!USERNAME_REGEX.matches(username)) {
            message = "Nombre de usuario inválido"
            return false
        }
        if (!PASSWORD_REGEX.matches(password)) {
            message = "Contraseña inválida"
            return false
        }
        return true
    }

    override fun checkData(): Boolean {
//        login(username, password) { loginResponse ->
//            println("Login Response: $loginResponse")
//        }
        return true
    }

    private fun login(username: String, password: String, callback: (String?) -> Unit) {
        val client = OkHttpClient()

        val json = JSONObject()
        json.put("username", username)
        json.put("password", password)

        val body = RequestBody.create("application/json".toMediaType(), json.toString())

        val request = Request.Builder()
            .url("$baseUrl/login")
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