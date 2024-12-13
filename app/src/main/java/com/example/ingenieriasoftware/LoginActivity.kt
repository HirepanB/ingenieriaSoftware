package com.example.ingenieriasoftware

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

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

            // Establece el OnClickListener para abrir LoginActivity2
            btnLogin.setOnClickListener {
                val intent = Intent(this, menuPrincipal::class.java)
                startActivity(intent) // Abre LoginActivity2
            }

//            // Validación simple (puedes agregar validaciones más complejas según sea necesario)
//            if (username.isNotEmpty() && password.isNotEmpty()) {
//                // Lógica de inicio de sesión (aquí puedes validar las credenciales, por ejemplo)
//                Toast.makeText(this, "Bienvenido, $username", Toast.LENGTH_SHORT).show()
//            } else {
//                // Muestra un mensaje de error si los campos están vacíos
//                Toast.makeText(this, "Por favor, ingrese usuario y contraseña", Toast.LENGTH_SHORT).show()
//            }
        }
    }
}