package com.example.wardafinal

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myDialoug = Dialog(this)
        val popup = findViewById<ImageView>(R.id.infoPopup)
        popup.setOnClickListener {
            myDialoug.setContentView(R.layout.popup_dialoug)
            myDialoug.setCancelable(true)
            myDialoug.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialoug.show()
        }
        val inch = findViewById<EditText>(R.id.inch)
        val feet = findViewById<EditText>(R.id.feet)
        val calculate = findViewById<Button>(R.id.calculateBtn)
        val showAns = findViewById<TextView>(R.id.ans)
        clearBtn.setOnClickListener {
            inch.setText("")
            feet.setText("")
            showAns.text = ""
        }
        calculate.setOnClickListener {
            var i1 = inch.text.toString().toFloat()
            var f1 = feet.text.toString().toFloat()
            //val ans = (f1 * 30.48) + (i1 * 12)
            if (i1 > 12 && i1 < 25){
                i1 -= 12
                f1 += 1
                val ans = ((f1 * 12) + i1) *2.54
                showAns.text = ans.toInt().toString() + " cm"
            }
            else if (i1 > 24){
                Toast.makeText(this, "${i1.toInt()} inches isn't valid", Toast.LENGTH_SHORT).show()
            }
            else {
                val ans = ((f1 * 12) + i1) *2.54
                showAns.text = ans.toInt().toString() + " cm"
            }
        }
    }
}