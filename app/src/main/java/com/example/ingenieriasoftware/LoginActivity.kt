package com.example.ingenieriasoftware

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Localiza el botón "INGRESAR"
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        // Establece el OnClickListener para abrir LoginActivity2
        btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity2::class.java)
            startActivity(intent) // Abre LoginActivity2
        }


        val btnRegister = findViewById<Button>(R.id.btnRegister)

        // Establece el OnClickListener para abrir LoginActivity2
        btnRegister.setOnClickListener {
            val intent = Intent(this, LoginActivity3::class.java)
            startActivity(intent) // Abre LoginActivity2
        }
    }
}