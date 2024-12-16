package com.example.ingenieriasoftware.ui.inventory

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ingenieriasoftware.InventoryListActivity
import com.example.ingenieriasoftware.MainMenuActivity
import com.example.ingenieriasoftware.R
import com.example.ingenieriasoftware.databinding.FragmentInventoryBinding

class InventoryFragment : Fragment() {

    private var _binding: FragmentInventoryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val inventoryViewModel =
            ViewModelProvider(this).get(InventoryViewModel::class.java)

        _binding = FragmentInventoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val view = inflater.inflate(R.layout.fragment_inventory, container, false);
        try {
            val btnOpenInventory = view.findViewById<ImageButton>(R.id.btn_open_inventory)
            btnOpenInventory.setOnClickListener {
                Log.i("yop", "wtf")
                val intent = Intent(
                    activity,
                    InventoryListActivity::class.java
                )
                startActivity(intent)
            }
        } catch (e : Exception) {
            e.message?.let { Log.i("yop", it) }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}