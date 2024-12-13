package com.example.ingenieriasoftware

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)


        // Localiza el botón "INGRESAR"
        val btnLogin = findViewById<Button>(R.id.btnGoToLogin)

        // Establece el OnClickListener para abrir LoginActivity
        btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent) // Abre LoginActivity
        }


        val tvRegister = findViewById<TextView>(R.id.tvGoToRegister)

        // Establece el OnClickListener para abrir RegisterActivity
        tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent) // Abre RegisterActivity
        }
    }
}