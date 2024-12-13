package com.example.ingenieriasoftware

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Encuentra los campos de entrada de texto y el botón
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etCorreo = findViewById<EditText>(R.id.correo)
        val etNumero = findViewById<EditText>(R.id.numero)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etPassword2 = findViewById<EditText>(R.id.etPassword2)
        val btnRegister = findViewById<Button>(R.id.btnLogin)

        // Configura el listener para el botón de registro
        btnRegister.setOnClickListener {
            val username = etUsername.text.toString()
            val correo = etCorreo.text.toString()
            val numero = etNumero.text.toString()
            val password = etPassword.text.toString()
            val password2 = etPassword2.text.toString()

            // Validación de los campos
            if (username.isNotEmpty() && correo.isNotEmpty() && numero.isNotEmpty() && password.isNotEmpty() && password2.isNotEmpty()) {
                // Verifica que las contraseñas coincidan
                if (password == password2) {
                    // Si las contraseñas coinciden, puedes continuar con el registro
                    // Aquí podrías hacer un llamado a una base de datos o a un API
                    Toast.makeText(this, "Registro exitoso!", Toast.LENGTH_SHORT).show()
                } else {
                    // Muestra un error si las contraseñas no coinciden
                    Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Muestra un mensaje de error si algún campo está vacío
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}