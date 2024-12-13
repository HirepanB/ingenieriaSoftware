package com.example.ingenieriasoftware

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)


        // Localiza el botón "INGRESAR"
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        // Establece el OnClickListener para abrir LoginActivity2
        btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent) // Abre LoginActivity2
        }


        val btnRegister = findViewById<Button>(R.id.btnRegister)

        // Establece el OnClickListener para abrir LoginActivity2
        btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent) // Abre LoginActivity2
        }
    }
}