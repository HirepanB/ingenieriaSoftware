package com.example.ingenieriasoftware

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.ingenieriasoftware.localstorage.entities.Inventory
import com.example.ingenieriasoftware.localstorage.viewmodels.InventoryEntityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewInventoryDialog : DialogFragment() {
    internal lateinit var listener: NoticeDialogListener
    private val inventoryEntityViewModel: InventoryEntityViewModel by viewModels()

    interface NoticeDialogListener {
        fun onDialogPositiveClick(dialog: DialogFragment)
        fun onDialogNegativeClick(dialog: DialogFragment)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val editText = EditText(context)
            builder.setMessage("Nombre del inventario")
                .setView(editText)
                .setPositiveButton("Crear") { dialog, id ->
                    inventoryEntityViewModel.addInventory(Inventory(
                        name  = editText.text.toString(),
                        coverString = ""
                    ))
                    listener.onDialogPositiveClick(this)
                }
                .setNegativeButton("Cancelar") { dialog, id ->
                    // User cancelled the dialog.
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as NoticeDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context.toString() +
                    " must implement NoticeDialogListener"))
        }
    }
}