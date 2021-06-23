package com.irzstudio.imagepicker

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.DialogFragment.STYLE_NORMAL
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showBottomDialog()

    }

    private fun showBottomDialog() {
        button.setOnClickListener {
            val bottomDialog = ActionBottom.newInstance()
            bottomDialog.show(supportFragmentManager, ActionBottom.TAG)
            bottomDialog.setStyle(STYLE_NORMAL, R.style.AppBottomSheetDialogTheme)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            val bmp: Bitmap = data?.extras?.get("data") as Bitmap
            imageView?.setImageBitmap(bmp)
        } else if (requestCode == 2) {
            imageView?.setImageURI(data?.data)
        }
    }

}