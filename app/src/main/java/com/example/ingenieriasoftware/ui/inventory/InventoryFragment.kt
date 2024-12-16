package com.example.ingenieriasoftware.ui.inventory

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.ingenieriasoftware.InventoryListActivity
import com.example.ingenieriasoftware.NewInventoryDialog
import com.example.ingenieriasoftware.R
import com.example.ingenieriasoftware.databinding.FragmentInventoryBinding
import com.example.ingenieriasoftware.localstorage.viewmodels.InventoryEntityViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InventoryFragment : Fragment(), NewInventoryDialog.NoticeDialogListener {

    private var _binding: FragmentInventoryBinding? = null
    private val inventoryEntityViewModel: InventoryEntityViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var view: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInventoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        view = inflater.inflate(R.layout.fragment_inventory, container, false);

        view.findViewById<FloatingActionButton>(R.id.btn_new_inventory).setOnClickListener {

            NewInventoryDialog().show(parentFragmentManager, "GAME_DIALOG")
        }
        loadInventories()
//        val btnOpenInventory = view.findViewById<ImageButton>(R.id.btn_open_inventory)
//        btnOpenInventory.setOnClickListener {
//            val intent = Intent(
//                activity,
//                InventoryListActivity::class.java
//            )
//            startActivity(intent)
//        }


        return view
    }

    override fun onDialogPositiveClick(dialog: DialogFragment) {
        Log.i("yop", "a")
        // User taps the dialog's positive button.
    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {
        // User taps the dialog's negative button.
    }

    private fun loadInventories() {
        try {
            val ly = view.findViewById<GridLayout>(R.id.layout_inventories)
            inventoryEntityViewModel.getInventories { inventories ->
                inventories.forEach { inventory ->
                    val itemView = LayoutInflater.from(context)
                        .inflate(R.layout.layout_button_open_inventory, ly, false)
                    itemView.findViewById<TextView>(R.id.label_open_inventory).text = inventory.name
                    itemView.setOnClickListener {
                        val intent = Intent(
                            activity,
                            InventoryListActivity::class.java
                        )
                        intent.putExtra("inventoryId", inventory.id)
                        startActivity(intent)
                    }
                    ly.addView(itemView)
                }
            }
        } catch (e: Exception) {
            e.message?.let { Log.i("yop", it) }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}