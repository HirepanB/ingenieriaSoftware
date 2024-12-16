package com.example.ingenieriasoftware

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ingenieriasoftware.utilities.validations.forms.RegisterValidator

class RegisterActivity : AppCompatActivity() {

    val baseUrl = "http://localhost:5000"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Encuentra los campos de entrada de texto y el botón
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etCorreo = findViewById<EditText>(R.id.correo)
        val etNumero = findViewById<EditText>(R.id.numero)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etPassword2 = findViewById<EditText>(R.id.etPassword2)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        // Configura el listener para el botón de registro
        btnRegister.setOnClickListener {
            val username = etUsername.text.toString()
            val correo = etCorreo.text.toString()
            val numero = etNumero.text.toString()
            val password = etPassword.text.toString()
            val password2 = etPassword2.text.toString()
            val registerValidator = RegisterValidator(username, correo, numero, password, password2)

            if (registerValidator.isValid()) {
                Toast.makeText(this, "Registro exitoso, por favor inicia sesión", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, registerValidator.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}