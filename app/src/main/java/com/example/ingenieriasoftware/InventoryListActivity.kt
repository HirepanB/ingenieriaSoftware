package com.example.ingenieriasoftware

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TableRow
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InventoryListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inventory_list)

        val btnInventoryLog = findViewById<TableRow>(R.id.btn_inventory_log)
        btnInventoryLog.setOnClickListener( {
            val intent = Intent(this, InventoryLogActivity::class.java)
            startActivity(intent)
        })
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}