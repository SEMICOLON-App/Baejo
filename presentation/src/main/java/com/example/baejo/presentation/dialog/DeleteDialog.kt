package com.example.baejo.presentation.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.Window
import androidx.databinding.DataBindingUtil
import com.example.baejo.R
import com.example.baejo.databinding.DialogDeleteBinding

class DeleteDialog(
    private val context: Context,
    private val title: String,
    private val detail: String,
    private val onDialogButtonClickListener: OnDialogButtonClickListener
) {

    interface OnDialogButtonClickListener {
        fun onDeleteClick()
        fun onNoClick()
    }

    fun callDialog() {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val binding: DialogDeleteBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.dialog_delete,
            null,
            false
        )
        dialog.setContentView(binding.root)

        binding.tvTitleDefaultDialog.text = title
        binding.tvDetailDefaultDialog.text = detail

        binding.btnOkDefaultDialog.setOnClickListener {
            onDialogButtonClickListener.onDeleteClick()
            dialog.dismiss()
        }

        binding.btnNoDefaultDialog.setOnClickListener {
            onDialogButtonClickListener.onNoClick()
            dialog.dismiss()
        }

        dialog.show()
    }
}