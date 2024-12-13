package com.example.ingenieriasoftware

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ingenieriasoftware.utilities.validations.data.PasswordValidator
import com.example.ingenieriasoftware.utilities.validations.data.UsernameValidator
import com.example.ingenieriasoftware.utilities.validations.forms.LoginValidator

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Encuentra los campos de entrada de texto y el botón
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        // Configura el listener para el botón de inicio de sesión
        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            val loginValidator = LoginValidator(username, password)

            if (loginValidator.isValid()) {
                Toast.makeText(this, "Bienvenid@ $username", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, menuPrincipal::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, loginValidator.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}