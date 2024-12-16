package com.example.ingenieriasoftware

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.ingenieriasoftware.localstorage.viewmodels.InventoryLogViewModel
import com.example.ingenieriasoftware.localstorage.viewmodels.ItemViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InventoryListActivity : AppCompatActivity() {

    private val inventoryLogViewModel: InventoryLogViewModel by viewModels()
    private val itemViewModel: ItemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inventory_list)
        loadInventoryLogs()

        findViewById<FloatingActionButton>(R.id.btn_new_inventory_log).setOnClickListener {

        }
    }

    private fun loadInventoryLogs() {
        try {
            val ly = findViewById<LinearLayout>(R.id.table_inventory)
            intent.getStringExtra("inventoryId")?.let {
                inventoryLogViewModel.getInventoryLogs(it) { logs ->
                    logs.forEach { log ->
                        val itemView = LayoutInflater.from(this)
                            .inflate(R.layout.layout_button_inventory_log, ly, false)
                        itemViewModel.getItemById(log.itemId) { item ->
                            itemView.findViewById<TextView>(R.id.label_inventory_name).text = item?.name
                        }
                        itemView.findViewById<TextView>(R.id.label_inventory_amount).text = log.amount.toString()
                        ly.addView(itemView)
                    }
                }
            }
        } catch (e: Exception) {
            e.message?.let { Log.i("yop", it) }
        }
    }
}