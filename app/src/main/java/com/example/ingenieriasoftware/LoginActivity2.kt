package com.example.ingenieriasoftware

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast  // Esta es la importación que faltaba
import androidx.appcompat.app.AppCompatActivity

class LoginActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        // Encuentra los campos de entrada de texto y el botón
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        // Configura el listener para el botón de inicio de sesión
        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            // Validación simple (puedes agregar validaciones más complejas según sea necesario)
            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Lógica de inicio de sesión (aquí puedes validar las credenciales, por ejemplo)
                Toast.makeText(this, "Bienvenido, $username", Toast.LENGTH_SHORT).show()
            } else {
                // Muestra un mensaje de error si los campos están vacíos
                Toast.makeText(this, "Por favor, ingrese usuario y contraseña", Toast.LENGTH_SHORT).show()
            }
        }
    }
}