package com.example.baejo.presentation.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.example.baejo.R

class LoadingDialog(
    private val context: Context
) {

    private val dialog = Dialog(context)

    fun callDialog() {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(R.layout.dialog_loading)
        dialog.show()
    }

    fun dismissDialog() {
        dialog.dismiss()
    }
}